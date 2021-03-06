package com.bottega.mybanke.services.withdrawal;

import java.math.BigDecimal;
import java.util.UUID;

public class CreditCard {

	private UUID cardId;
	private BigDecimal creditLimit;
	private BigDecimal creditTaken;

	public WithdrawalWasSuccess withdraw(WithdrawCommand command, Atm atm) {

		if (atm.isNotTrusted()) {
			throw new RuntimeException();
		}

		if (command.getAmount().compareTo(availableMoney()) > 0) {
			throw new RuntimeException("Limit exceeded");
		} else {
			creditTaken = creditTaken.add(command.getAmount());
			return new WithdrawalWasSuccess(cardId, command.getAmount(), availableMoney());
		}
	}

	private BigDecimal availableMoney() {
		return creditLimit.subtract(creditTaken);
	}

}
