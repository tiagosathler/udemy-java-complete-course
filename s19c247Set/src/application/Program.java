package application;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		Set<Integer> cohortA = new HashSet<>();
		System.out.print("How many students for course A? ");
		int n = sc.nextInt();
		cohortA = addStudentsFromCourse(sc, n, cohortA);

		Set<Integer> cohortB = new HashSet<>();
		System.out.print("How many students for course B? ");
		n = sc.nextInt();
		cohortB = addStudentsFromCourse(sc, n, cohortB);

		Set<Integer> cohortC = new HashSet<>();
		System.out.print("How many students for course C? ");
		n = sc.nextInt();
		cohortC = addStudentsFromCourse(sc, n, cohortC);

		Set<Integer> students = new HashSet<>(cohortA);
		students.addAll(cohortB);
		students.addAll(cohortC);

		System.out.println("TOTAL STUDENTS: " + students.size());
		System.out.println("STUDENTS: " + students);

		sc.close();
	}

	public static Set<Integer> addStudentsFromCourse(Scanner sc, int n, Set<Integer> set) {
		for (int i = 1; i <= n; i++) {
			int id = sc.nextInt();
			set.add(id);
			sc.nextLine();
		}
		return set;
	}

}
