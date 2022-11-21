package com.vecv.aws;

import javax.annotation.PostConstruct;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.iot.AWSIotClient;
import com.amazonaws.services.iot.AWSIotClientBuilder;
import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;

@Service
public class AWSClientConnection {

	private static final Logger LOGGER = LoggerFactory.getLogger(AWSClientConnection.class);

	@Value("${vecv.aws.iot.endpoint}")
	private String clientEndPoint;

	@Value("${vecv.aws.accessid}")
	private String awsAccessId;

	@Value("${vecv.aws.secretkey}")
	private String awsSecretKey;

	private AWSIotMqttClient awsMqttClientCon = null;
	private AWSIotClient awsIotClientCon = null;

	@PostConstruct
	private void createAWSIotMqttClientConnection() throws AWSIotException {

		LOGGER.info("--------------------------------------------------");
		LOGGER.info("Inside Creating AWS MQTT Client Connection");

		String clientId = MqttClient.generateClientId();
		String sessionToken = null;

		LOGGER.info("Cleint Endpoint Id: {}", clientEndPoint);
		LOGGER.info("Cleint Id: {}", clientId);
		LOGGER.info("Aws Access ID: {}", awsAccessId);
		LOGGER.info("Aws Secret Key: {}", awsSecretKey);

		if (awsMqttClientCon == null) {
			if (awsAccessId != null && awsSecretKey != null) {
				awsMqttClientCon = new AWSIotMqttClient(clientEndPoint, clientId, awsAccessId, awsSecretKey,
						sessionToken);
				awsMqttClientCon.connect();
			}
		}
		LOGGER.info("AWS Mqtt Connection Made Success: {}", awsMqttClientCon);
		LOGGER.info("--------------------------------------------------");
	}

	@PostConstruct
	private void createAWSIotClientConnection() {
		LOGGER.info("--------------------------------------------------");
		LOGGER.info("Inside Creating AWS IOT Client Connection");

		LOGGER.info("Aws Access Key: {}", awsAccessId);
		LOGGER.info("Aws Secret Access ID: {}", awsSecretKey);
		if (awsIotClientCon == null) {
			if (awsAccessId != null && awsSecretKey != null) {
				// For local test
				AWSCredentials credentials = new BasicAWSCredentials(awsAccessId, awsSecretKey);

				// For Production
//				AWSCredentials credentials = new EnvironmentVariableCredentialsProvider().getCredentials();
				awsIotClientCon = (AWSIotClient) AWSIotClientBuilder.standard()
						.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_1)
						.build();

			}
		}

		LOGGER.info("AWS IOT Connection Made Success {}", awsIotClientCon);
		LOGGER.info("--------------------------------------------------");
	}

	public AWSIotMqttClient getAWSIotMqttClientCon() {
		return awsMqttClientCon;
	}

	public AWSIotClient getAWSIotClient() {
		return awsIotClientCon;
	}

}
