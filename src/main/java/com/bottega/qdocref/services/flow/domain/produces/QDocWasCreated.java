package com.bottega.qdocref.services.flow.domain.produces;

import com.bottega.qdocref.services.DomainEvent;
import lombok.Value;

@Value
public class QDocWasCreated implements DomainEvent {

	private String qDocNumber;

}
