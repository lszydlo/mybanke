package com.bottega.qdocref.services.flow;

import java.util.UUID;

public interface FlowRepo {
	void save(FlowService.QDocFlow flow);

	FlowService.QDocFlow load(UUID id);
}
