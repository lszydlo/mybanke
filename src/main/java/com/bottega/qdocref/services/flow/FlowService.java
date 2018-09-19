package com.bottega.qdocref.services.flow;

import com.bottega.qdocref.services.flow.consumes.DoCreateQDoc;
import com.bottega.qdocref.services.flow.consumes.DoPublishQDoc;
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

		QDocFlow flow = new QDocFlow(numberPolicy.generate());

		repo.save(flow);
	}

	public void handle(DoPublishQDoc command) {


		QDocFlow flow = repo.load(command.getId());

		ValidationPolicy validationPolicy = new ValidationPolicy("ISO");
		flow.publish(validationPolicy);


		repo.save(flow);
	}

	class QDocFlow {

		private QDocNumber number;
		private QDocStatus status;

		QDocFlow(QDocNumber number) {

			this.number = number;
		}

		void publish(ValidationPolicy validationPolicy) {
			if (status == QDocStatus.VERIFIED) {
				validationPolicy.validate(QDocStatus.PUBLISHED, getFlowData());
				this.status = QDocStatus.PUBLISHED;
			} else {
				throw new RuntimeException();
			}
		}

		private FlowData getFlowData() {
			return new FlowData();
		}

		class FlowData {
		}
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
