package com.bottega.mybanke.services.admin;

import com.bottega.mybanke.services.withdrawal.WithdrawalWasSuccess;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WithdrawalReader {

	JdbcOperations jdbcOperations;


	@EventListener
	public void listenOn(WithdrawalWasSuccess event) {
		// jdbcOperations./////
	}



	public List<WithdrawalReadModel> read(WithdrawalListQuery query) {
		return jdbcOperations.queryForList("select * from withdrawals where cardId = ?", WithdrawalReadModel.class, query.cardId);
	}
}
