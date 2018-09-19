package com.bottega.qdocref.services.flow.domain;

import com.bottega.qdocref.services.DomainEvent;
import com.bottega.qdocref.services.flow.domain.ports.FlowDao;
import com.bottega.qdocref.services.flow.domain.ports.QDocFlowRecord;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@AllArgsConstructor
class FlowRepo {

	private final FlowDao flowDao;



	void apply(UUID id, Function<QDocFlow, DomainEvent> consumer) {
		Optional<QDocFlowRecord> recordOption = flowDao.findById(id);

		QDocFlowRecord record2 = recordOption.orElseThrow(() -> new RuntimeException("not found"));

		QDocFlow qDocFlow = getQDocFlow(record2);

		DomainEvent event = consumer.apply(qDocFlow);

		record2.apply(event);

		flowDao.save(record2);

	}

	private QDocFlow getQDocFlow(QDocFlowRecord record2) {
		// Handle null
		QDocNumber qDocNumber = new QDocNumber(record2.getQDocNumber());
		QDocStatus qDocStatus = QDocStatus.valueOf(record2.getStatus());
		boolean hasContent = record2.hasContent();

		return new QDocFlow(qDocNumber, qDocStatus, hasContent);
	}
}
