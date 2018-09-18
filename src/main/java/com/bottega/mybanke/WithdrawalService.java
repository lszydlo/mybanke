package com.bottega.mybanke;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class WithdrawalService {

	private WithdrawalRepo repo;
	private ApplicationEventPublisher publisher;

	@Transactional
	public void handle(WithdrawCommand command) {

		CreditCard card = repo.load(command.getCardId());

		WithdrawalWasSuccess event = card.withdraw(command);
		publisher.publishEvent(event);

		repo.save(card);
	}

}
