package s05c37EstruturaCondicional;

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
//		Main.exercicio07();
		Main.exercicio08();
	}

	public static void exercicio01() {
		/*
		 * Fazer um programa para ler um número inteiro e dizer se este número é par ou
		 * ímpar.
		 */

		System.out.println("Exercício 1:");

		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();

		if (input >= 0) {
			System.out.println("NAO NEGATIVO");
		} else {
			System.out.println("NEGATIVO");
		}

		sc.close();
	}

	public static void exercicio02() {
		/*
		 * Fazer um programa para ler um número inteiro e dizer se este número é par ou
		 * ímpar.
		 */

		System.out.println("Exercício 2:");

		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();

		if (Math.abs(input) % 2 == 1) {
			System.out.println("IMPAR");
		} else {
			System.out.println("PAR");
		}

		sc.close();
	}

	public static void exercicio03() {
		/*
		 * Leia 2 valores inteiros (A e B). Após, o programa deve mostrar uma mensagem
		 * "Sao Multiplos" ou "Nao sao Multiplos", indicando se os valores lidos são
		 * múltiplos entre si. Atenção: os números devem poder ser digitados em ordem
		 * crescente ou decrescente.
		 */
		System.out.println("Exercício 3:");

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int divisor, dividendo;

		if (a > b) {
			divisor = b;
			dividendo = a;
		} else {
			divisor = a;
			dividendo = b;
		}

		if (dividendo % divisor == 0) {
			System.out.println("Sao Multiplos");
		} else {
			System.out.println("Nao sao Multiplos");
		}

		sc.close();
	}

	public static void exercicio04() {
		/*
		 * Leia a hora inicial e a hora final de um jogo. A seguir calcule a duração do
		 * jogo, sabendo que o mesmo pode começar em um dia e terminar em outro, tendo
		 * uma duração mínima de 1 hora e máxima de 24 horas.
		 */
		System.out.println("Exercício 4:");

		Scanner sc = new Scanner(System.in);

		int start = sc.nextInt();
		int end = sc.nextInt();

		int hours;

		if (start > end) {
			hours = 24 - start + end;
		} else if (start < end) {
			hours = end - start;
		} else {
			hours = 24;
		}
		System.out.printf("%nO JOGO DUROU %d HORA(S)", hours);

		sc.close();
	}

	public static void exercicio05() {
		/*
		 * Com base na tabela abaixo, escreva um programa que leia o código de um item e
		 * a quantidade deste item. A seguir, calcule e mostre o valor da conta a pagar.
		 * *
		 */
		System.out.println("Exercício 5:");
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		int id = sc.nextInt();
		int amount = sc.nextInt();

		double total;

		switch (id) {
		case 1:
//				Cachorro quente
			total = amount * 4.00;
			break;
		case 2:
//				X-Salada
			total = amount * 4.50;
			break;
		case 3:
//				X-Bacon
			total = amount * 5.00;
			break;
		case 4:
//				Torrada simples
			total = amount * 2.00;
			break;
		case 5:
//				Refrigerante
			total = amount * 1.50;
			break;
		default:
			System.out.println("Produto invalido");
			sc.close();
			return;
		}

		System.out.printf("%nTotal: R$ %.2f", total);

		sc.close();
	}

	public static void exercicio06() {
		/*
		 * Você deve fazer um programa que leia um valor qualquer e apresente uma
		 * mensagem dizendo em qual dos seguintes intervalos ([0,25], (25,50], (50,75],
		 * (75,100]) este valor se encontra. Obviamente se o valor não estiver em nenhum
		 * destes intervalos, deverá ser impressa a mensagem “Fora de intervalo”.
		 */
		System.out.println("Exercício 6:");
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		double value = sc.nextDouble();

		if (value > 0 && value <= 25) {
			System.out.println("Intervalo (0, 25]");
		} else if (value > 25 && value <= 50) {
			System.out.println("Intervalo (25, 50]");
		} else if (value > 50 && value <= 75) {
			System.out.println("Intervalo (50, 75]");
		} else if (value > 75 && value <= 100) {
			System.out.println("Intervalo (75, 100]");
		} else {
			System.out.println("Fora de intervalo");
		}

		sc.close();
	}

	public static void exercicio07() {
		/*
		 * Leia 2 valores com uma casa decimal (x e y), que devem representar as
		 * coordenadas de um ponto em um plano. A seguir, determine qual o quadrante ao
		 * qual pertence o ponto, ou se está sobre um dos eixos cartesianos ou na origem
		 * (x = y = 0). Se o ponto estiver na origem, escreva a mensagem “Origem”. Se o
		 * ponto estiver sobre um dos eixos escreva “Eixo X” ou “Eixo Y”, conforme for a
		 * situação.
		 */
		System.out.println("Exercício 7:");
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		double x = sc.nextDouble();
		double y = sc.nextDouble();

		if (x > 0 && y > 0) {
			System.out.println("Q1");
		} else if (x < 0 && y > 0) {
			System.out.println("Q2");
		} else if (x < 0 && y < 0) {
			System.out.println("Q3");
		} else if (x > 0 && y < 0) {
			System.out.println("Q4");
		} else {
			System.out.println("Origem");
		}

		sc.close();
	}

	public static void exercicio08() {
		/*
		 * Em um país imaginário denominado Lisarb, todos os habitantes ficam felizes em
		 * pagar seus impostos, pois sabem que nele não existem políticos corruptos e os
		 * recursos arrecadados são utilizados em benefício da população, sem qualquer
		 * desvio. A moeda deste país é o Rombus, cujo símbolo é o R$.
		 * 
		 * Leia um valor com duas casas decimais, equivalente ao salário de uma pessoa
		 * de Lisarb. Em seguida, calcule e mostre o valor que esta pessoa deve pagar de
		 * Imposto de Renda, segundo a tabela abaixo.
		 * 
		 * RENDA IMPOSTO de 0.00 a 2000.00 isento de 2000.01 a 3000.00 8 % de 3000.01 a
		 * 4500.00 18 % acima de 4500.00 28 %
		 * 
		 * Lembre que, se o salário for R$ 3002.00, a taxa que incide é de 8% apenas
		 * sobre R$ 1000.00, pois a faixa de salário que fica de R$ 0.00 até R$ 2000.00
		 * é isenta de Imposto de Renda. No exemplo fornecido (abaixo), a taxa é de 8%
		 * sobre R$ 1000.00 + 18% sobre R$ 2.00, o que resulta em R$ 80.36 no total. O
		 * valor deve ser impresso com duas casas decimais.
		 */
		System.out.println("Exercício 8:");
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		double salary = sc.nextDouble();
		double tax;

		if (salary <= 2000) {
			System.out.println("Isento");
		} else if (salary > 2000 && salary <= 3000) {
			tax = (salary - 3000) * 0.08;
			System.out.printf("%n R$ %.2f%n", tax);
		} else if (salary > 3000 && salary <= 4500) {
			tax = 1000.00 * 0.08 + (salary - 3000) * 0.18;
			System.out.printf("%n R$ %.2f%n", tax);
		} else {
			tax = 1000.00 * 0.08 + 1500 * 0.18 + (salary - 4500) * 0.28;
			System.out.printf("%n R$ %.2f%n", tax);
		}

		sc.close();
	}
}
