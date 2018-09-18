package com.bottega.mybanke.gateway;


import com.bottega.mybanke.services.admin.WithdrawalListQuery;
import com.bottega.mybanke.services.admin.WithdrawalReadModel;
import com.bottega.mybanke.services.admin.WithdrawalReader;
import com.bottega.mybanke.services.withdrawal.WithdrawCommand;
import com.bottega.mybanke.services.withdrawal.WithdrawalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WithdrawalController {

	private WithdrawalService withdrawalService;
	private WithdrawalReader withdrawalReader;

	@PostMapping("/withdrawal")
	public void withdraw(@RequestBody WithdrawCommand command) {
		withdrawalService.handle(command);
	}


	public List<WithdrawalReadModel> get(WithdrawalListQuery query) {
		return withdrawalReader.read(query);
	}




}
