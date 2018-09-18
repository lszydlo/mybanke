package com.bottega.mybanke;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;

public class WithdrawalService {

	WithdrawalRepo repo;
	ApplicationEventPublisher publisher;

	@Transactional
	public void handle(WithdrawCommand command) {

		CreditCard card = repo.load(command.getCardId());

		WithdrawalWasSuccess event = card.withdraw(command);
		publisher.publishEvent(event);

		repo.save(card);
	}

}
