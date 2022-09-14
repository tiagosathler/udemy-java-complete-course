package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		List<Product> products = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Product #" + i + " data:");

			System.out.print("Common, used or imported (c/u/i)? ");
			char choice = sc.nextLine().charAt(0);

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (choice == 'u' || choice == 'U') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String dateString = sc.next();

				LocalDate manufactureDate = LocalDate.parse(dateString, fmt);
				products.add(new UsedProduct(name, price, manufactureDate));
			}

			else if (choice == 'i' || choice == 'I') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();

				products.add(new ImportedProduct(name, price, customsFee));
			}

			else {
				products.add(new Product(name, price));
			}
		}

		System.out.println("PRICE TAGS:");

		for (Product product : products) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}

}
