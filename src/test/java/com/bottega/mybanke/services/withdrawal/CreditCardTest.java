package com.bottega.mybanke.services.withdrawal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class CreditCardTest {

	@Test
	public void should_not_allow_withdrawal_for_not_trusted_atm() {

		CreditCard card = new CreditCard();

		assertThatThrownBy(
				() -> {
					WithdrawCommand command = new WithdrawCommand(new BigDecimal(12), UUID.randomUUID());
					card.withdraw(command,new Atm(false));
				})
				.isInstanceOf(RuntimeException.class);

	}
}