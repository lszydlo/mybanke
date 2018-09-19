package com.bottega.qdocref.services.flow.domain.ports;

import com.bottega.qdocref.services.DomainEvent;
import com.bottega.qdocref.services.flow.domain.produces.QDocWasCreated;
import com.bottega.qdocref.services.flow.domain.produces.QDocWasPublished;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.UUID;

@Entity
@Data
public class QDocFlowRecord {

	@Id
	private UUID id;
	@Version
	private Long version;
	private String qDocNumber;
	private String status;
	private String content;

	public boolean hasContent() {
		return !content.isEmpty();
	}

	public void apply(DomainEvent event) {
		if (event instanceof QDocWasPublished) {
			status = "PUBLISHED";
		} else if (event instanceof QDocWasCreated) {
			this.qDocNumber = ((QDocWasCreated) event).getQDocNumber();
			status = "DRAFT";
		} else {
			throw new RuntimeException();
		}
	}
}
