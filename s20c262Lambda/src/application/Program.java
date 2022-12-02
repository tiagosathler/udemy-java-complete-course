package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter full file path:");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			List<Employee> employees = new ArrayList<>();

			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(",");

				String name = fields[0];
				String email = fields[1];
				double salary = Double.parseDouble(fields[2]);

				employees.add(new Employee(name, email, salary));

				line = br.readLine();
			}

			System.out.print("Enter salary base: ");
			double salaryBase = sc.nextDouble();

			List<String> emailsFilteredBySalary = employees.stream()
					.filter(e -> e.getSalary() >= salaryBase)
					.map(e -> e.getEmail())
					.sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
					.collect(Collectors.toList());

			emailsFilteredBySalary.forEach(System.out::println);

			System.out.println();

			System.out.print("Enter the first letter to filter by name: ");
			char letter = sc.next().toUpperCase().charAt(0);

			double sumOfSalariesFilteredByFirstLetter = employees.stream()
					.filter(e -> e.getName().toUpperCase().charAt(0) == letter)
					.map(e -> e.getSalary())
					.reduce(0.0, (s1, s2) -> s1 + s2);

			System.out.printf("Sum of salary of people whose name starts with '%c': %.2f\n", letter,
					sumOfSalariesFilteredByFirstLetter);

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Error parsing double number: " + e.getMessage());
		}
		sc.close();
	}

}
