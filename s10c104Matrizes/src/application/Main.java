package application;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		sc.nextLine();

		int[][] mat = new int[n][m];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}

		sc.nextLine();

		int number = sc.nextInt();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				Integer up = null;
				Integer left = null;
				Integer down = null;
				Integer right = null;
				if (mat[i][j] == number) {
					System.out.printf("%nPosition %d, %d:%n---%n", i, j);
//					INNER:
					if (i > 0 && j > 0 && i < mat.length - 1 && j < mat[i].length - 1) {
						left = mat[i][j - 1];
						right = mat[i][j + 1];
						up = mat[i - 1][j];
						down = mat[i + 1][j];
					}
//					Q1:
					else if (i == 0 && j == 0) {
//						left = mat[i][j - 1];
						right = mat[i][j + 1];
//						up = mat[i - 1][j];
						down = mat[i + 1][j];
					}
//					Q2:
					else if (i == mat.length - 1 && j == 0) {
//						left = mat[i][j - 1];
						right = mat[i][j + 1];
						up = mat[i - 1][j];
//						down = mat[i + 1][j];
					}
//					Q3: 
					else if (i == mat.length - 1 && j == mat[i].length - 1) {
						left = mat[i][j - 1];
//						right = mat[i][j + 1];
						up = mat[i - 1][j];
//						down = mat[i + 1][j];
					}
//					Q4: 
					else if (i == 0 && j == mat[i].length - 1) {
						left = mat[i][j - 1];
//						right = mat[i][j + 1];
//						up = mat[i - 1][j];
						down = mat[i + 1][j];
					}
//					FIRST LINE AND INNER COLUMN:
					else if (i == 0 && j > 0 && j < mat[i].length - 1) {
						left = mat[i][j - 1];
//						up = mat[i - 1][j];
						right = mat[i][j + 1];
						down = mat[i + 1][j];
					}
//					LAST LINE and INNER COLUMN:
					else if (i == mat.length - 1 && j > 0 && j < mat[i].length - 1) {
						left = mat[i][j - 1];
						up = mat[i - 1][j];
						right = mat[i][j + 1];
//						down = mat[i + 1][j];
					}
//					INNER LINE AND FIRST COLUMN:
					else if (j == 0 && i > 0 && i < mat.length - 1) {
//						left = mat[i][j - 1];
						up = mat[i - 1][j];
						right = mat[i][j + 1];
						down = mat[i + 1][j];
					}
//					INNER LINE and LAST COLUMN:
					else if (i > 0 && i < mat.length - 1 && j == mat[i].length - 1) {
						left = mat[i][j - 1];
						up = mat[i - 1][j];
//						right = mat[i][j + 1];
						down = mat[i + 1][j];
					}
				}
				if (left != null) {
					System.out.printf("Left: %d%n", left);
				}
				if (right != null) {
					System.out.printf("Right: %d%n", right);
				}
				if (up != null) {
					System.out.printf("Up: %d%n", up);
				}
				if (down != null) {
					System.out.printf("Down: %d%n", down);
				}
			}
		}

		sc.close();

	}

}
