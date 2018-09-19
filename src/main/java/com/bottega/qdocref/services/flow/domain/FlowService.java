package com.bottega.qdocref.services.flow.domain;

import com.bottega.qdocref.services.flow.domain.consumes.DoCreateQDoc;
import com.bottega.qdocref.services.flow.domain.consumes.DoPublishQDoc;
import com.bottega.qdocref.services.flow.domain.ports.SystemConfig;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class FlowService {


	private final FlowRepo repo;
	private final QDocNumberPolicyProvider provider;


	public void handle(DoCreateQDoc command) {
		QDocNumberPolicy numberPolicy = provider.get();

		repo.apply(command.getId(),
				qDocFlow -> qDocFlow.create(numberPolicy.generate()));

	}

	public void handle(DoPublishQDoc command) {

		repo.apply(command.getId(),
				flow -> flow.publish(new ValidationPolicy("ISO")));

	}

	@Value
	class QDocNumberPolicy {

		private final SystemConfig config;
		private final CurrentUser user;
		private final Long next;
		private final LocalDate date;


		public QDocNumber generate() {
			QDocNumber qDocNumber = new QDocNumber(next, date, config.getSystemType());
			if (config.isDemo()) {
				qDocNumber = qDocNumber.addPrefix("DEMO");
			}
			if (user.isAuditor()) {
				qDocNumber = qDocNumber.addSuffix("AUDIT");
			}
			return qDocNumber;
		}
	}
}
