package com.bottega.qdocref.services.flow;

import java.time.LocalDate;

public class QDocNumber {

	private static final String SEPARATOR = "/";
	private final String number;




	public QDocNumber(Long next, LocalDate date, String systemType) {
		number = systemType + SEPARATOR + next + SEPARATOR + date.getMonthValue() + SEPARATOR + date.getYear();
	}

	private QDocNumber(String number) {
		this.number = number;
	}

	public QDocNumber addPrefix(String prefix) {
		return new QDocNumber(prefix + SEPARATOR + number);
	}

	public QDocNumber addSuffix(String suffix) {

		return new QDocNumber( number + SEPARATOR + suffix);
	}
}
