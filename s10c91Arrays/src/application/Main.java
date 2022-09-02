package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Grades;
import entities.Person;

public class Main {

	private static final int MINOR_AGE = 16;

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

//		negativos(sc);
//		somaVetor(sc);
//		alturas(sc);
//		numerosPares(sc);
//		maiorPosicao(sc);
//		somaVetores(sc);
//		abaixoDaMedia(sc);
//		mediaPares(sc);
//		maisVelho(sc);
//		aprovados(sc);
		dadosPessoas(sc);

		sc.close();
	}

	public static void negativos(Scanner sc) {
		/*
		 * Faça um programa que leia um número inteiro positivo N (máximo = 10) e depois
		 * N números inteiros e armazene-os em um vetor. Em seguida, mostrar na tela
		 * todos os números negativos lidos.
		 */

		System.out.print("Quantos numeros voce vai digitar? ");

		int n = sc.nextInt();

//		int[] vect = new int[n];
		int[] vect = createIntVector(n, sc);

		for (int i = 0; i < vect.length; i++) {
			if (vect[i] < 0) {
				System.out.println(vect[i]);
			}
		}
	}

	public static void somaVetor(Scanner sc) {
		/*
		 * Faça um programa que leia N números reais e armazene-os em um vetor. Em
		 * seguida: - Imprimir todos os elementos do vetor - Mostrar na tela a soma e a
		 * média dos elementos do vetor
		 */
		System.out.print("Quantos numeros voce vai digitar? ");

		int n = sc.nextInt();

//		double[] vect = new double[n];
		double[] vect = createDoubleVector(n, sc);

		double sum = 0.0;

		for (int i = 0; i < vect.length; i++) {
			sum += vect[i];
		}

		double avg = sum / vect.length;

		System.out.print("VALORES =");

		for (int i = 0; i < vect.length; i++) {
			System.out.printf(" %.1f ", vect[i]);
		}

		System.out.printf("%nSOMA = %.2f%n", sum);
		System.out.printf("MEDIA = %.2f%n", avg);
	}

	public static void alturas(Scanner sc) {
		/*
		 * Fazer um programa para ler nome, idade e altura de N pessoas, conforme
		 * exemplo. Depois, mostrar na tela a altura média das pessoas, e mostrar também
		 * a porcentagem de pessoas com menos de 16 anos, bem como os nomes dessas
		 * pessoas caso houver.
		 */
		System.out.print("Quantas pessoas serao digitadas? ");
		int n = sc.nextInt();

		Person[] vect = new Person[n];

		double sumOfHeight = 0.0;
		int underageCount = 0;

		for (int i = 0; i < vect.length; i++) {
			sc.nextLine();
			System.out.printf("Dados da %dª pessoa:%n", i + 1);

			System.out.print("Nome: ");
			String name = sc.nextLine();

			System.out.print("Idade: ");
			int age = sc.nextInt();

			sc.nextLine();
			System.out.print("Altura: ");
			double height = sc.nextDouble();

			vect[i] = new Person(name, age, height);
			sumOfHeight += vect[i].getHeight();

			if (vect[i].getAge() < MINOR_AGE) {
				underageCount += 1;
			}
		}

		double avgOfHeight = sumOfHeight / vect.length;
		double percentageOfMinors = (double) 100 * underageCount / vect.length;

		System.out.printf("%nAltura média: %.2f%n", avgOfHeight);
		System.out.printf("Pessoas com menos de 16 anos: %.2f %% %n", percentageOfMinors);

		for (int i = 0; i < vect.length; i++) {
			if (vect[i].getAge() < MINOR_AGE) {
				System.out.println(vect[i].getName());
			}
		}
	}

	public static void numerosPares(Scanner sc) {
		/*
		 * Faça um programa que leia N números inteiros e armazene-os em um vetor. Em
		 * seguida, mostre na tela todos os números pares, e também a quantidade de
		 * números pares.
		 */
		System.out.print("Quantos numeros voce vai digitar? ");

		int n = sc.nextInt();

//		int[] vect = new int[n];
		int[] vect = createIntVector(n, sc);

		int evenCount = 0;

		System.out.println("NUMEROS PARES:");

		for (int i = 0; i < vect.length; i++) {
			if (vect[i] % 2 == 0) {
				System.out.printf("%d  ", vect[i]);
				evenCount += 1;
			}
		}

		System.out.printf("%nQUANTIDADE DE PARES = %d", evenCount);
	}

	public static void maiorPosicao(Scanner sc) {
		/*
		 * Faça um programa que leia N números reais e armazene-os em um vetor. Em
		 * seguida, mostrar na tela o maior número do vetor (supor não haver empates).
		 * Mostrar também a posição do maior elemento, considerando a primeira posição
		 * como 0 (zero).
		 */
		System.out.print("Quantos numeros voce vai digitar? ");
		int n = sc.nextInt();

//		double[] vect = new double[n];
		double[] vect = createDoubleVector(n, sc);

		double maxValue = vect[0];
		int index = 0;

		for (int i = 1; i < vect.length; i++) {
			if (vect[i] > maxValue) {
				maxValue = vect[i];
				index = i;
			}
		}

		System.out.printf("%nMAIOR VALOR = %.1f", maxValue);
		System.out.printf("%nPOSICAO DO MAIOR VALOR = %d", index);
	}

	public static void somaVetores(Scanner sc) {
		/*
		 * Faça um programa para ler dois vetores A e B, contendo N elementos cada. Em
		 * seguida, gere um terceiro vetor C onde cada elemento de C é a soma dos
		 * elementos correspondentes de A e B. Imprima o vetor C gerado.
		 */
		System.out.print("Quantos valores vai ter cada vetor? ");
		int n = sc.nextInt();

		System.out.println("Digite os valores do vetor A:");
		int[] vectA = createIntVector(n, sc);

		System.out.println("Digite os valores do vetor B:");
		int[] vectB = createIntVector(n, sc);

		int[] sumVectors = new int[n];

		for (int i = 0; i < n; i++) {
			sumVectors[i] = vectA[i] + vectB[i];
		}

		System.out.println("VETOR RESULTANTE:");

		for (int i = 0; i < n; i++) {
			System.out.println(sumVectors[i]);
		}
	}

	public static void abaixoDaMedia(Scanner sc) {
		/*
		 * Fazer um programa para ler um número inteiro N e depois um vetor de N números
		 * reais. Em seguida, mostrar na tela a média aritmética de todos elementos com
		 * três casas decimais. Depois mostrar todos os elementos do vetor que estejam
		 * abaixo da média, com uma casa decimal cada.
		 */
		System.out.print("Quantos elementos vai ter o vetor? ");
		int n = sc.nextInt();

		double[] vect = new double[n];

		double sum = 0.0;

		for (int i = 0; i < vect.length; i++) {
			sc.nextLine();
			System.out.print("Digite um numero: ");
			vect[i] = sc.nextDouble();
			sum += vect[i];
		}

		double avg = sum / vect.length;

		System.out.printf("%nMEDIA DO VETOR = %.3f%n", avg);
		System.out.println("ELEMENTOS ABAIXO DA MEDIA:");

		for (int i = 0; i < vect.length; i++) {
			if (vect[i] < avg) {
				System.out.println(vect[i]);
			}
		}
	}

	public static void mediaPares(Scanner sc) {
		/*
		 * Fazer um programa para ler um vetor de N números inteiros. Em seguida,
		 * mostrar na tela a média aritmética somente dos números pares lidos, com uma
		 * casa decimal. Se nenhum número par for digitado, mostrar a mensagem
		 * "NENHUM NUMERO PAR"
		 */
		System.out.print("Quantos numeros vai ter o vetor? ");
		int n = sc.nextInt();

		int[] vect = createIntVector(n, sc);

		double sum = 0.0;
		int count = 0;

		for (int i = 0; i < vect.length; i++) {
			if (vect[i] % 2 == 0) {
				sum += (double) vect[i];
				count += 1;
			}
		}

		if (count != 0) {
			double avg = sum / count;
			System.out.printf("%nMEDIA DOS PARES = %.1f", avg);
		} else {
			System.out.println("NENHUM NUMERO PAR");
		}
	}

	public static void maisVelho(Scanner sc) {
		/*
		 * Fazer um programa para ler um conjunto de nomes de pessoas e suas respectivas
		 * idades. Os nomes devem ser armazenados em um vetor, e as idades em um outro
		 * vetor. Depois, mostrar na tela o nome da pessoa mais velha.
		 */
		System.out.print("Quantas pessoas você vai digitar? ");
		int n = sc.nextInt();

		Person[] vect = new Person[n];
		int maxAge = 0;
		String olderPerson = "";

		for (int i = 0; i < vect.length; i++) {
			sc.nextLine();
			System.out.printf("Dados da %dª pessoa: %n", i + 1);

			System.out.print("Nome: ");
			String name = sc.nextLine();

			System.out.print("Idade: ");
			int age = sc.nextInt();

			vect[i] = new Person(name, age);

			if (vect[i].getAge() > maxAge) {
				maxAge = vect[i].getAge();
				olderPerson = vect[i].getName();
			}
		}

		System.out.println("PESSOA MAIS VELHA: " + olderPerson);
	}

	public static void aprovados(Scanner sc) {
		/*
		 * Fazer um programa para ler um conjunto de N nomes de alunos, bem como as
		 * notas que eles tiraram no 1º e 2º semestres. Cada uma dessas informações deve
		 * ser armazenada em um vetor. Depois, imprimir os nomes dos alunos aprovados,
		 * considerando aprovados aqueles cuja média das notas seja maior ou igual a 6.0
		 * (seis).
		 */
		System.out.printf("Quantas alunos serão digitados? ");
		int n = sc.nextInt();

		Grades[] vect = new Grades[n];

		for (int i = 0; i < vect.length; i++) {
			sc.nextLine();
			System.out.printf("Dados da %dª pessoa:%n", i + 1);

			System.out.printf("Nome: ");
			String name = sc.nextLine();

			vect[i] = new Grades(name, 2);

			System.out.printf("Primeira nota: ");
			double firstGrade = sc.nextDouble();
			vect[i].addGrade(firstGrade);

			System.out.printf("Segunda nota: ");
			double secondGrade = sc.nextDouble();
			vect[i].addGrade(secondGrade);
		}

		System.out.println("Alunos aprovados:");

		for (int i = 0; i < vect.length; i++) {
			boolean approved = true;
			double[] grades = vect[i].getGrades();

			for (int j = 0; j < grades.length; j++) {
				if (grades[j] < 5.5) {
					approved = false;
				}
			}

			if (approved) {
				System.out.println(vect[i].getName());
			}
		}
	}

	public static void dadosPessoas(Scanner sc) {
		/*
		 * Tem-se um conjunto de dados contendo a altura e o gênero (M, F) de N pessoas.
		 * Fazer um programa que calcule e escreva a maior e a menor altura do grupo, a
		 * média de altura das mulheres, e o número de homens.
		 */
		System.out.printf("Quantas pessoas serão digitados? ");
		int n = sc.nextInt();

		Person[] vect = new Person[n];

		for (int i = 0; i < vect.length; i++) {
			sc.nextLine();
			System.out.printf("Dados da %dª pessoa:%n", i + 1);

			System.out.print("Genero: ");
			char gender = sc.nextLine().charAt(0);

			System.out.print("Altura: ");
			double height = sc.nextDouble();

			vect[i] = new Person(height, gender);
		}

		double sumOfMenHeight = 0.0;
		int menCount = 0;

		double shorterHeight = 100;
		double greatestHeight = 0.0;

		double sumOfWomenHeight = 0.0;
		int womenCount = 0;

		for (int i = 0; i < vect.length; i++) {
			if (vect[i].getHeight() < shorterHeight) {
				shorterHeight = vect[i].getHeight();
			}
			if (vect[i].getHeight() > greatestHeight) {
				greatestHeight = vect[i].getHeight();
			}
			if (vect[i].getGender() == 'M') {
				menCount += 1;
				sumOfMenHeight += vect[i].getHeight();
			} else if (vect[i].getGender() == 'F') {
				womenCount += 1;
				sumOfWomenHeight += vect[i].getHeight();
			}
		}

		System.out.printf("%nMenor altura: %.2f%n", shorterHeight);
		System.out.printf("%Maior altura: %.2f%n", greatestHeight);

		if (menCount > 0) {
			double menAvg = sumOfMenHeight / menCount;
			System.out.printf("%Média das altura dos homens = %.2f%n", menAvg);
			System.out.printf("%Quantidade de homens = %d%n", menCount);
		}

		if (womenCount > 0) {
			double womenAvg = sumOfWomenHeight / womenCount;
			System.out.printf("%Média das altura das mulheres = %.2f%n", womenAvg);
			System.out.printf("%Quantidade de homens = %d%n", womenCount);
		}

	}

	public static int[] createIntVector(int n, Scanner sc) {
		int[] vect = new int[n];
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.print("Digite um numero: ");
			vect[i] = sc.nextInt();
		}
		return vect;
	}

	public static double[] createDoubleVector(int n, Scanner sc) {
		double[] vect = new double[n];
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.print("Digite um numero: ");
			vect[i] = sc.nextDouble();
		}
		return vect;
	}
}
