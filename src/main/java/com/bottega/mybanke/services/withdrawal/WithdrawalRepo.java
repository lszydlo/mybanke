package com.bottega.mybanke.services.withdrawal;

import java.util.UUID;

public interface WithdrawalRepo {
	CreditCard load(UUID cardId);

	void save(CreditCard card);
}
