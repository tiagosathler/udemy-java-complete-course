package s06c54EstruturasRepetitivas;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Main.exercicio01();
//		Main.exercicio02();
//		Main.exercicio03();
//		Main.exercicio04();
//		Main.exercicio05();
//		Main.exercicio06();
		Main.exercicio07();
	}

	public static void exercicio01() {
		/*
		 * Leia um valor inteiro X (1 <= X <= 1000). Em seguida mostre os ímpares de 1
		 * até X, um valor por linha, inclusive o X, se for o caso.
		 */
		System.out.println("Exercício 1");

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		for (int i = 1; i <= x; i++) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		}
		sc.close();

	}

	public static void exercicio02() {
		/*
		 * Leia um valor inteiro N. Este valor será a quantidade de valores inteiros X
		 * que serão lidos em seguida. Mostre quantos destes valores X estão dentro do
		 * intervalo [10,20] e quantos estão fora do intervalo, mostrando essas
		 * informações conforme exemplo (use a palavra "in" para dentro do intervalo, e
		 * "out" para fora do intervalo).
		 */
		System.out.println("Exercício 2");
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int min = 10;
		int max = 20;

		int countInterval = 0;

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			if (input >= min && input <= max) {
				countInterval++;
			}
		}

		System.out.println(countInterval + " in");
		System.out.println(N - countInterval + " out");

		sc.close();
	}

	public static void exercicio03() {
		/*
		 * Leia 1 valor inteiro N, que representa o número de casos de teste que vem a
		 * seguir. Cada caso de teste consiste de 3 valores reais, cada um deles com uma
		 * casa decimal. Apresente a média ponderada para cada um destes conjuntos de 3
		 * valores, sendo que o primeiro valor tem peso 2, o segundo valor tem peso 3 e
		 * o terceiro valor tem peso 5.
		 */
		System.out.println("Exercício 3");
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			double first = sc.nextDouble();
			double second = sc.nextDouble();
			double third = sc.nextDouble();

			double weightedSum = first * 2.0 + second * 3.0 + third * 5.0;
			double weightedAverage = weightedSum / (2.0 + 3.0 + 5.0);
			System.out.printf("%.1f%n", weightedAverage);

		}
		sc.close();
	}

	public static void exercicio04() {
		/*
		 * Fazer um programa para ler um número N. Depois leia N pares de números e
		 * mostre a divisão do primeiro pelo segundo. Se o denominador for igual a zero,
		 * mostrar a mensagem "divisao impossivel".
		 */
		System.out.println("Exercício 4");
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int dividendo = sc.nextInt();
			int divisor = sc.nextInt();

			if (divisor == 0) {
				System.out.println("divisao impossivel");
				continue;
			}

			double divisao = (double) dividendo / divisor;
			System.out.printf("%.1f%n", divisao);
		}
		sc.close();
	}

	public static void exercicio05() {
		/*
		 * Ler um valor N. Calcular e escrever seu respectivo fatorial. Fatorial de N =
		 * N * (N-1) * (N-2) * (N-3) * ... * 1. Lembrando que, por definição, fatorial
		 * de 0 é 1.
		 */
		System.out.println("Exercício 5");
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int fatorial = 1;

		for (int i = 1; i <= n; i++) {
			fatorial *= i;
		}
		System.out.println(fatorial);
		sc.close();
	}

	public static void exercicio06() {
		/*
		 * Ler um número inteiro N e calcular todos os seus divisores.
		 */
		System.out.println("Exercício 6");
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.println(i);
			}
		}
		sc.close();
	}

	public static void exercicio07() {
		/*
		 * Fazer um programa para ler um número inteiro positivo N. O programa deve
		 * então mostrar na tela N linhas, começando de 1 até N. Para cada linha,
		 * mostrar o número da linha, depois o quadrado e o cubo do valor, conforme
		 * exemplo.
		 */
		System.out.println("Exercício 7");t
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if (n > 0) {
			for (int l = 1; l <= n; l++) {
				System.out.printf("%d %d %d%n", l, l * l, l * l * l);
			}
		}
		sc.close();
	}
}
