package com.bottega.mybanke.services.admin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class WithdrawalReadModel {

	UUID cardId;
	BigDecimal amount;
	LocalDateTime dateTime;
	BigDecimal availableAmount;

}
