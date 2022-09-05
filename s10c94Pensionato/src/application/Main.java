package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Student;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();

		Student[] rooms = new Student[10];

		for (int i = 0; i < n; i++) {
			sc.nextLine();

			System.out.printf("Rent #%d%n", i + 1);

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.printf("Email: ");
			String email = sc.nextLine();

			System.out.printf("Room: ");
			int room = sc.nextInt();

			rooms[room - 1] = new Student(name, email);
		}

		System.out.println("Busy rooms:");
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i] != null) {
				System.out.printf("%d: %s%n", i + 1, rooms[i]);
			}
		}

		sc.close();
	}

}
