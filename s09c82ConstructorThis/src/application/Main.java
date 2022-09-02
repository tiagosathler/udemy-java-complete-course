package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter account number: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter account holder: ");
		String holder = sc.nextLine();

		System.out.print("Is there an initial deposit (y/n)? ");
		char answer = sc.nextLine().charAt(0);

		Account account;

		double value, amount;

		if (answer == 'y' || answer == 'Y') {
			System.out.print("Enter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			account = new Account(id, holder, initialDeposit);
		} else {
			account = new Account(id, holder);
		}

		System.out.println("Account data:");
		System.out.println(account);

		System.out.print("Enter a deposit value: ");
		value = sc.nextDouble();
		account.deposit(value);

		System.out.println("Updated account data:");
		System.out.println(account);

		System.out.print("Enter a withdraw value: ");
		amount = sc.nextDouble();
		account.withdraw(amount);

		System.out.println("Updated account data:");
		System.out.println(account);

		sc.close();
	}

}
