package com.bottega.qdocref.services.editor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "qdoc")
public class QDocContent {

	@Id
	UUID id;
	@Version
	Long version;
	@NotNull
	String title;
	@Max(12)
	String content;
}
