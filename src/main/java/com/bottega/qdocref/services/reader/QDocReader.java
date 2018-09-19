package com.bottega.qdocref.services.reader;

import org.springframework.context.event.EventListener;

import java.util.UUID;

public class QDocReader {


	private QDocRepo repo;


	QDocReadModel get(UUID uuid) {
		return repo.findById(uuid).orElseThrow(RuntimeException::new);
	}

	@EventListener
	public void listenOn(QMWasCreated event)  {
		// insert
	}
	@EventListener
	public void listenOn(QMWasUpdated event)  {
		// update
	}
}
