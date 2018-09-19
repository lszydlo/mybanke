package com.bottega.qdocref.services.reader;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QDocRepo extends JpaRepository<QDocReadModel, UUID> {
}
