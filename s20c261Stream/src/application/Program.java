package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> products = new ArrayList<>();

		System.out.println("Enter full file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(",");

				String name = fields[0];
				double price = Double.parseDouble(fields[1]);

				products.add(new Product(name, price));

				line = br.readLine();
			}

			double sum = products.stream()
					.map(p -> p.getPrice())
					.reduce(0.0, (x, y) -> x + y);

			double avg = sum / products.size();

			List<String> productsName = products.stream()
					.filter(p -> p.getPrice() <= avg)
					.sorted((p1, p2) -> (int) (p2.getPrice() - p1.getPrice()))
					.map(p -> p.getName())
					.collect(Collectors.toList());

			System.out.println("Average price: " + String.format("%.2f", avg));
			System.out.println();
			
			System.out.println("List of below average products \n(ordered from most expensive to least expensive):");
			productsName.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Error parsing Double: " + e.getMessage());
		}
		sc.close();
	}

}
