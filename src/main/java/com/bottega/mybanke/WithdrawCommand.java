package com.bottega.mybanke;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class WithdrawCommand {

	@NotNull
	private BigDecimal amount;

	@NotNull
	private UUID cardId;

}
