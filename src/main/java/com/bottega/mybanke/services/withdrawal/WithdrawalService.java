package com.bottega.mybanke.services.withdrawal;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class WithdrawalService {

	private WithdrawalRepo repo;
	private ApplicationEventPublisher publisher;
	private CurrentAtmClient currentAtmClient;

	@Transactional
	public void handle(WithdrawCommand command) {

		CreditCard card = repo.load(command.getCardId());

		Atm atm = currentAtmClient.get();
		WithdrawalWasSuccess event = card.withdraw(command, atm);
		publisher.publishEvent(event);

		repo.save(card);
	}

}
