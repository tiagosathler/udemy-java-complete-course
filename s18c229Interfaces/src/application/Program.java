package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Contract;
import models.entities.Installment;
import models.services.ContractService;
import models.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre os dados do contrato:");

		System.out.print("Número do contrato: ");
		int number = sc.nextInt();

		System.out.print("Data (dd/MM/yyyy): ");
		String dateStr = sc.next();

		LocalDate date = LocalDate.parse(dateStr, fmt);

		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();

		System.out.print("Entre com o número de parcelas: ");
		int installments = sc.nextInt();

		Contract contract = new Contract(number, date, totalValue);
		ContractService contractService = new ContractService(new PaypalService());

		contractService.processContract(contract, installments);

		System.out.println("PARCELAS:");

		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment.toString(fmt));
		}

		sc.close();
	}

}
