package models.services;

import java.time.LocalDate;

import models.entities.Contract;
import models.entities.Installment;

public class ContractService {
	private OnlinePaymentService paymentService;

	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract, int months) {
		double monthlyBasis = contract.getTotalValue() / months;
		for (int month = 1; month <= months; month++) {
			double interest = paymentService.interest(monthlyBasis, month);
			double paymentFee = paymentService.paymentFee(monthlyBasis + interest);

			LocalDate dueDate = contract.getDate().plusMonths(month);
			Installment installment = new Installment(dueDate, monthlyBasis + interest + paymentFee);
			contract.addInstallment(installment);
		}
	}
}
