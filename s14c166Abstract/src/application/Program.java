package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CompanyPayer;
import entities.IndividualPayer;
import entities.Payer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		List<Payer> payers = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Tax payer #" + i + " data:");

			System.out.print("Individual or company (i/c)? ");
			char choice = sc.nextLine().charAt(0);

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();

			if (choice == 'i' || choice == 'I') {
				System.out.print("Health expenditures: ");
				double health = sc.nextDouble();

				payers.add(new IndividualPayer(name, anualIncome, health));
			} else {
				System.out.print("Number of employees: ");
				int employees = sc.nextInt();

				payers.add(new CompanyPayer(name, anualIncome, employees));
			}
		}

		System.out.println();
		System.out.println("TAXES PAID:");

		for (Payer payer : payers) {
			System.out.printf("%s: $ %.2f%n", payer.getName(), payer.calculateTax());
		}

		sc.close();
	}

}
