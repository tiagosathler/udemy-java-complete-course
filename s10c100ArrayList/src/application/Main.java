package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> employees = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		System.out.println("-----");

		for (int i = 0; i < n; i++) {
			sc.nextLine();

			System.out.println("Employee #" + (i + 1) + ":");

			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.printf("Name: ");
			String name = sc.nextLine();

			System.out.print("Salary ");
			double salary = sc.nextDouble();

			Employee employee = new Employee(id, name, salary);
			employees.add(employee);
			System.out.println("-----");
		}

		sc.nextLine();

		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		sc.nextLine();

		Employee foundEmployee = employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);

		if (foundEmployee != null) {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			sc.nextLine();
			foundEmployee.increaseSalary(percentage);
		} else {
			System.out.println("This id does not exist!");
		}

		System.out.println("-----");

		System.out.println("List of employees:");
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		sc.close();
	}

}
