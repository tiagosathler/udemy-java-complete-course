package s04c30EstruturaSequencial;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Main.exercise01();
//		Main.exercise02();
//		Main.exercise03();
//		Main.exercise04();
//		Main.exercise05();
		Main.exercise06();

	}

	public static void exercise01() {
		System.out.println("Exercício 1:");
		System.out.println("Soma de X e Y (int)");

		Scanner sc = new Scanner(System.in);

		int x, y;

		x = sc.nextInt();
		sc.nextLine();
		y = sc.nextInt();

		int sum = x + y;
		System.out.println("SOMA = " + sum);

		sc.close();
	}

	public static void exercise02() {
		System.out.println("Exercício 2:");
		System.out.println("Área de um círculo de raio R (double)");

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		double r, area;

		r = sc.nextDouble();
		area = Math.PI * Math.pow(r, 2);

		System.out.printf("%nA=%.4f", area);

		sc.close();
	}

	public static void exercise03() {
		System.out.println("Exercício 3:");
		System.out.println("Diferença entre produtos - A*B - C*D (int)");

		Scanner sc = new Scanner(System.in);

		int a, b, c, d;
		a = sc.nextInt();
		sc.nextLine();
		b = sc.nextInt();
		sc.nextLine();
		c = sc.nextInt();
		sc.nextLine();
		d = sc.nextInt();

		int result = a * b - c * d;

		System.out.println("DIFERENCA = " + result);

		sc.close();
	}

	public static void exercise04() {
		System.out.println("Exercício 4:");
		System.out.println("Calcula as horas de trabalho de um funcionário");

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		int id, workedHours;
		double valuePerHour;

		id = sc.nextInt();
		sc.nextLine();
		workedHours = sc.nextInt();
		sc.nextLine();
		valuePerHour = sc.nextDouble();

		double total = workedHours * valuePerHour;
		System.out.println("NUMBER = " + id);
		System.out.printf("%nSALARY = U$ %.2f%n", total);

		sc.close();
	}

	public static void exercise05() {
		System.out.println("Exercício 5:");
		System.out.println("Calcule o valor total de 2 peças");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int pieceId1, pieceId2, amountPiece1, amountPiece2;
		double valuePiece1, valuePiece2;

		pieceId1 = sc.nextInt();
		amountPiece1 = sc.nextInt();
		valuePiece1 = sc.nextDouble();
		sc.nextLine();

		pieceId2 = sc.nextInt();
		amountPiece2 = sc.nextInt();
		valuePiece2 = sc.nextDouble();

		double total = amountPiece1 * valuePiece1 + amountPiece2 * valuePiece2;

		System.out.printf("%nVALOR A PAGAR: R$ %.2f%n", total);

		sc.close();
	}

	public static void exercise06() {
		System.out.println("Exercício 6:");
		System.out.println("Áreas de triângulo, círculo, trapézio, quadrado e retângulo");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double a, b, c;

		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();

		double triangle = a * c / 2.0;
		double circle = Math.PI * Math.pow(c, 2);
		double trapeze = (a + b) * c / 2.0;
		double square = Math.pow(b, 2);
		double rectangle = a * b;

		String report = "%n" + "TRIANGULO: %.3f%n" + "CIRCULO: %.3f%n" + "TRAPEZIO: %.3f%n" + "QUADRADO: %.3f%n"
				+ "RETANGULO: %.3f%n";

		System.out.printf(report, triangle, circle, trapeze, square, rectangle);

		sc.close();
	}
}