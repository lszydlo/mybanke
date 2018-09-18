package com.bottega.mybanke;

import java.util.UUID;

public interface WithdrawalRepo {
	CreditCard load(UUID cardId);

	void save(CreditCard card);
}
