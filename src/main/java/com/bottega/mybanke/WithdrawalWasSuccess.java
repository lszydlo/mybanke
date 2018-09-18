package com.bottega.mybanke;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class WithdrawalWasSuccess {
	private final UUID cardId;
	private final BigDecimal amount;
	private final BigDecimal availableMoney;
	private final LocalDateTime dateTime;

	public WithdrawalWasSuccess(UUID cardId, BigDecimal amount, BigDecimal availableMoney) {
		this.dateTime = LocalDateTime.now();
		this.cardId = cardId;
		this.amount = amount;
		this.availableMoney = availableMoney;
	}
}
