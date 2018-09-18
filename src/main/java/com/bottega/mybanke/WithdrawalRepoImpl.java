package com.bottega.mybanke;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class WithdrawalRepoImpl implements WithdrawalRepo {
	@Override
	public CreditCard load(UUID cardId) {
		return null;
	}

	@Override
	public void save(CreditCard card) {

	}
}
