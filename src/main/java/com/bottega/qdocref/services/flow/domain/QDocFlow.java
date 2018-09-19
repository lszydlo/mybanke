package com.bottega.qdocref.services.flow.domain;

import com.bottega.qdocref.services.DomainEvent;
import com.bottega.qdocref.services.flow.domain.produces.QDocWasCreated;
import com.bottega.qdocref.services.flow.domain.produces.QDocWasPublished;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class QDocFlow {

	private final QDocNumber number;
	private final QDocStatus status;
	private final boolean hasContent;

	DomainEvent create(QDocNumber number) {
		return new QDocWasCreated(number.value());
	}

	DomainEvent publish(ValidationPolicy validationPolicy) {
		if (status == QDocStatus.VERIFIED) {
			validationPolicy.validate(QDocStatus.PUBLISHED, getFlowData());
			return new QDocWasPublished();
		} else {
			throw new RuntimeException();
		}
	}

	private FlowData getFlowData() {
		return new FlowData();
	}

	class FlowData {
	}
}
