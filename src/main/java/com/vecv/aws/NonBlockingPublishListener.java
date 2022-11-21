package com.vecv.aws;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotQos;

public class NonBlockingPublishListener extends AWSIotMessage {

	private static final Logger logger = LoggerFactory.getLogger(NonBlockingPublishListener.class);

	public NonBlockingPublishListener(String topic, AWSIotQos qos, String payload) {
		super(topic, qos, payload);
	}

	@Override
	public void onSuccess() {
		logger.info(new Date() + "Data published successfully >>>" + getStringPayload());
	}

	@Override
	public void onFailure() {
		logger.info(new Date() + ": publish failed for " + getStringPayload());
	}

	@Override
	public void onTimeout() {
		logger.info((new Date() + ": publish timeout for " + getStringPayload()));
	}

}
