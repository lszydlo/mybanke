package com.bottega.qdocref.services.reader;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "qdoc")
@Data
public class QDocReadModel {

	@Id
	UUID id;
	@Version
	Long version;
	String status;
	String content;

	@OneToMany
	QDocAuthor qDocAuthor;

	UUID authorId;

}
