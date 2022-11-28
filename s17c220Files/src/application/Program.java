package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter CSV filename full path:");
		String sourceFilePathStr = sc.nextLine();

		File sourceFile = new File(sourceFilePathStr);
		String parentFolderStr = sourceFile.getParent();

		List<Product> products = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFilePathStr))) {
			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				String[] columns = line.split(",");

				String name = columns[0];
				Double price = Double.parseDouble(columns[1]);
				Integer quantity = Integer.parseInt(columns[2]);

				Product product = new Product(name, price, quantity);
				products.add(product);

				line = br.readLine();
			}

			new File(parentFolderStr + "/out").mkdir();

			String targetFilePathStr = parentFolderStr + "/out/summary.csv";
			System.out.println(targetFilePathStr);

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilePathStr))) {
				for (Product product : products) {
					bw.write(product.getSummary());
				}

			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		catch (NumberFormatException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
