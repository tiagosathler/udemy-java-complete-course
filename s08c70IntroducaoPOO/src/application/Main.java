package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.Rectangle;
import entities.Student;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

//		Main.exercicio01();
//		Main.exercicio02();
		exercicio03();

	}

	public static void exercicio01() {
		/*
		 * Fazer um programa para ler os valores da largura e altura de um reatângulo.
		 * Em seguida, mostrar na tela o valor de sua área, perímetro e diagonal
		 */
		Scanner sc = new Scanner(System.in);

		Rectangle rectangle = new Rectangle();
		System.out.println("Enter rectangle width and height:");

		rectangle.width = sc.nextDouble();
		rectangle.height = sc.nextDouble();

		System.out.printf("AREA: %.2f%n", rectangle.area());
		System.out.printf("PERIMETER: %.2f%n", rectangle.perimeter());
		System.out.printf("DIAGONAL: %.2f%n", rectangle.diagonal());

		sc.close();
	}

	public static void exercicio02() {
		/*
		 * Fazer um programa para ler os dados de um funcionário (nome, salário bruto e
		 * imposto). Em seguida, mostar os dados do funcionário (nome e salário
		 * líquido). Em seguida, aumentar o salário do funcionário com base em uma
		 * porcentagem dada (somente o slário bruto é afetado pela porcentagem) e
		 * mostrar novamente os dados do funcinário.
		 * 
		 */
		Scanner sc = new Scanner(System.in);

		Employee employee = new Employee();

		System.out.print("Name: ");
		employee.name = sc.nextLine();

		System.out.print("Gross salary: ");
		employee.grossSalary = sc.nextDouble();

		System.out.print("Tax: ");
		employee.tax = sc.nextDouble();

		System.out.println("Employee: " + employee);

		System.out.print("Which percentage to increase salary? ");
		double percentage = sc.nextDouble();

		employee.increaseSalary(percentage);

		System.out.println("Updated data: " + employee);

		sc.close();
	}

	public static void exercicio03() {
		/*
		 * Fazer um programa para ler o nome de um aluno e as três notas que ele obteve
		 * nos três trimestres do ano (primeiro trimestre vale 30, o segundo e terceiro
		 * valem 35 cada). Ao final, mostrar qual a nota final do aluno no ano. Dizer
		 * também se o aluno está aprovado (PASS) ou não (FAILED) e, em caso negativo,
		 * mostrar quantos pontos faltam para o aluno obter o mínimo para ser aprovado
		 * (que é 60% da nota). Você deve criar uma classe Student para resolver este
		 * problema.
		 */
		Scanner sc = new Scanner(System.in);

		Student student = new Student();

		student.name = sc.nextLine();

		student.firstGrade = sc.nextDouble();
		student.secondGrade = sc.nextDouble();
		student.thirdGrade = sc.nextDouble();

		System.out.println("FINAL GRADE = " + student.getFinalGrade());
		if (student.isItApproved()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAILED");
			System.out.printf("MISSING %.2f POINTS", student.needToApprove());
		}

		sc.close();
	}

}
