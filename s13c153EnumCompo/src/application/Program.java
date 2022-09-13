package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter cliente data:");

		System.out.print("Name: ");
		String clientName = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthDateStr = sc.nextLine();
		LocalDate birthdate = LocalDate.parse(birthDateStr, fmt);

		Client client = new Client(clientName, email, birthdate);

		System.out.println("-----------");
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.nextLine();

		Order order = new Order(client, OrderStatus.valueOf(status));

		System.out.println("Hom many items to this order? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("----");
			System.out.println("Enter #" + i + " item data:");

			System.out.print("Product name: ");
			String productName = sc.nextLine();

			System.out.print("Product price: ");
			double price = sc.nextDouble();

			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			Product product = new Product(productName, price);
			OrderItem orderItem = new OrderItem(quantity, product);

			order.addItem(orderItem);
		}

		System.out.println(order);

		sc.close();
	}

}
