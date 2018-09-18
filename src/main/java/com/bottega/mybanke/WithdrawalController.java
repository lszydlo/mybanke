package com.bottega.mybanke;


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
