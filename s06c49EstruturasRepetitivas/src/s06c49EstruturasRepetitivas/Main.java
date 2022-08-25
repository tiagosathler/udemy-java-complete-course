package s06c49EstruturasRepetitivas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Main.exercicio01();
//		Main.exercicio02();
		Main.exercicio03();
	}

	public static void exercicio01() {
		/*
		 * Escreva um programa que repita a leitura de uma senha até que ela seja
		 * válida. Para cada leitura de senha incorreta informada, escrever a mensagem
		 * "Senha Invalida". Quando a senha for informada corretamente deve ser impressa
		 * a mensagem "Acesso Permitido" e o algoritmo encerrado. Considere que a senha
		 * correta é o valor 2002.
		 */
		System.out.println("Exercício 1");
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();

		while (input != 2002) {
			input = sc.nextInt();
			System.out.println("Senha Invalida");
		}

		System.out.println("Acesso Permitido");

		sc.close();
	}

	public static void exercicio02() {
		/*
		 * Escreva um programa para ler as coordenadas (X,Y) de uma quantidade
		 * indeterminada de pontos no sistema cartesiano. Para cada ponto escrever o
		 * quadrante a que ele pertence. O algoritmo será encerrado quando pelo menos
		 * uma de duas coordenadas for NULA (nesta situação sem escrever mensagem
		 * alguma).
		 */
		System.out.println("Exercício 2");
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		while (x != 0 && y != 0) {
			if (x > 0 && y > 0) {
				System.out.println("primeiro");
			} else if (x < 0 && y > 0) {
				System.out.println("segundo");
			} else if (x < 0 && y < 0) {
				System.out.println("terceiro");
			} else {
				System.out.println("quarto");
			}
			x = sc.nextInt();
			y = sc.nextInt();
		}

		sc.close();
	}

	public static void exercicio03() {
		/*
		 * Um Posto de combustíveis deseja determinar qual de seus produtos tem a
		 * preferência de seus clientes. Escreva um algoritmo para ler o tipo de
		 * combustível abastecido (codificado da seguinte forma: 1.Álcool 2.Gasolina
		 * 3.Diesel 4.Fim). Caso o usuário informe um código inválido (fora da faixa de
		 * 1 a 4) deve ser solicitado um novo código (até que seja válido). O programa
		 * será encerrado quando o código informado for o número 4. Deve ser escrito a
		 * mensagem: "MUITO OBRIGADO" e a quantidade de clientes que abasteceram cada
		 * tipo de combustível, conforme exemplo.
		 */
		System.out.println("Exercício 3");
		Scanner sc = new Scanner(System.in);

		int gas, alc, die;
		gas = alc = die = 0;

		int input = sc.nextInt();

		while (input != 4) {
			switch (input) {
			case 1: {
				gas += 1;
				break;
			}
			case 2: {
				alc += 1;
				break;
			}
			case 3: {
				die += 1;
				break;
			}
			}
			input = sc.nextInt();
		}

		System.out.printf("%nMUITO OBRIGADO%nAlcool: %d%nGasolina: %d%nDiesel: %d%n", gas, alc, die);
		sc.close();
	}

}
