package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import entities.UserLog;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file full path: ");
		String pathStr = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(pathStr))) {
			Set<UserLog> users = new HashSet<>();

			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(" ");
				String name = fields[0];
				Date access = Date.from(Instant.parse(fields[1]));

				users.add(new UserLog(name, access));

				line = br.readLine();
			}

			System.out.println("Total users: " + users.size());

			for (UserLog user : users) {
				System.out.println(user);
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		} catch (DateTimeParseException e) {
			System.out.println("Error parsing date: " + e.getMessage());
		}

		sc.close();
	}

}
