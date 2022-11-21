package com.vecv.aws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotQos;

@Component
public class PublishSubscriber {

	private static final Logger logger = LoggerFactory.getLogger(PublishSubscriber.class);

	private static final String TOPIC_NAME = "Ev_trips/";
	private static final AWSIotQos TOPIC_QOS = AWSIotQos.QOS0;

	@Autowired
	private AWSClientConnection aWSClientConnection;
	/*
	 * private static AWSIotMqttClient awsIotClient;
	 * 
	 * @Value("${mqqtt.private.file}") private String privateFile;
	 * 
	 * @Value("${mqtt.certificate.file}") private String certificateFile;
	 * 
	 * @Value("${mqtt.clientEndpoint}") private String clientEndpoint;
	 * 
	 * @PostConstruct private void loadConfig() { initClient(); try {
	 * awsIotClient.connect(); } catch (AWSIotException e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * private void initClient() { logger.info("Initializing the awsIotClient");
	 * 
	 * String clientId = MqttClient.generateClientId(); if (awsIotClient == null &&
	 * certificateFile != null && privateFile != null) { String algorithm = "RSA";
	 * KeyStorePasswordPair pair =
	 * SampleUtil.getKeyStorePasswordPair(certificateFile, privateFile, algorithm);
	 * awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, pair.keyStore,
	 * pair.keyPassword); }
	 * 
	 * if (awsIotClient == null) { throw new
	 * IllegalArgumentException("Failed to construct client due to missing certificate or credentials."
	 * ); }
	 * 
	 * logger.info("initialization completed"); }
	 */

	public void sendData(String data) {
		logger.info("**************MQTT START********************");

		AWSIotMessage message = new NonBlockingPublishListener(TOPIC_NAME, TOPIC_QOS, data);
		try {
//			awsIotClient.publish(message);
			aWSClientConnection.getAWSIotMqttClientCon().publish(message);
		} catch (AWSIotException e) {
//			logger.info(System.currentTimeMillis() + ": publish failed for " + message);
			logger.info("{}: publish failed for {}", System.currentTimeMillis(), message);
		}
		logger.info("**************MQTT END******************");

	}

	public void sendData(String data, String topic) {
		logger.info("**************MQTT START********************");

		AWSIotMessage message = new NonBlockingPublishListener(topic, TOPIC_QOS, data);
		try {
//			awsIotClient.publish(message);
			aWSClientConnection.getAWSIotMqttClientCon().publish(message);
		} catch (AWSIotException e) {
			logger.info("{}: publish failed for {}", System.currentTimeMillis(), message);
		}
		logger.info("**************MQTT END******************");
	}

}
