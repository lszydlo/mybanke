package com.bottega.qdocref.services.flow.domain.ports;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlowDao extends JpaRepository<QDocFlowRecord, UUID> {
}
