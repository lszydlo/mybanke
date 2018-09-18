package com.bottega.mybanke.services.withdrawal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawCommand {

	@NotNull
	private BigDecimal amount;

	@NotNull
	private UUID cardId;

}
