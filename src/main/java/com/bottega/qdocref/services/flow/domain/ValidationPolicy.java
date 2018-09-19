package com.bottega.qdocref.services.flow.domain;

class ValidationPolicy {
	private String systemType;

	ValidationPolicy(String systemType) {
		this.systemType = systemType;
	}

	void validate(QDocStatus destinationStatus, QDocFlow.FlowData flowData) {

	}
}
