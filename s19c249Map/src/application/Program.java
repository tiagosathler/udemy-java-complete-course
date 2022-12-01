package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter file full path: ");
		String path = sc.next();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			Map<String, Integer> polling = new LinkedHashMap<>();

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");

				String candidateName = fields[0];
				Integer candidateVotes = Integer.parseInt(fields[1]);

				if (polling.containsKey(candidateName)) {
					candidateVotes += polling.get(candidateName);
				}

				polling.put(candidateName, candidateVotes);

				line = br.readLine();
			}

			for (String candidateName : polling.keySet()) {
				System.out.println(candidateName + ": " + polling.get(candidateName));
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Error parsing number: " + e.getMessage());
		}

		sc.close();
	}

}
