package com.bottega.mybanke.services.withdrawal;

public class Atm {
	private boolean trusted;

	public Atm(boolean trusted) {

		this.trusted = trusted;
	}

	public boolean isNotTrusted() {
		return !trusted;
	}
}
