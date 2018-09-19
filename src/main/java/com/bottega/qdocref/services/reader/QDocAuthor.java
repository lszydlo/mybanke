package com.bottega.qdocref.services.reader;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class QDocAuthor {

	@Id
	UUID id;
	String name;
}
