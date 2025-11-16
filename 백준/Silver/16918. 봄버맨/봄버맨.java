import java.io.*;
import java.util.*;

public class Main {

	static String[] input;
	static String[][][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		input = reader.readLine().split(" ");

		int R = Integer.parseInt(input[0]); // R행
		int C = Integer.parseInt(input[1]); // C열
		int N = Integer.parseInt(input[2]); // N초가 흐른 후의 상태를 보자고

		arr = new String[201][R][C]; // 3차원 시간 개념 포함

		for (int i = 0; i < R; i++) {
			String str = reader.readLine();

			for (int j = 0; j < C; j++) {
				arr[0][i][j] = str.charAt(j) + "";
				arr[1][i][j] = str.charAt(j) + "";
			}
		}

		if (N == 1) {
			printArr(R, C, 1);
			return;
		}

		for (int i = 2; i <= N; i++) {
			if (i % 2 == 0) {
				makeO(R, C, i);
			} else {
				for (int j = 0; j < R; j++) {
					for (int k = 0; k < C; k++) {
						arr[i][j][k] = arr[i - 1][j][k];
					}
				}

				for (int j = 0; j < R; j++) {
					for (int k = 0; k < C; k++) {

						if (arr[i - 3][j][k].equals("O") && arr[i - 2][j][k].equals("O")) {
							arr[i][j][k] = ".";

							if (j - 1 >= 0) {
								arr[i][j - 1][k] = ".";
							}
							if (k - 1 >= 0) {
								arr[i][j][k - 1] = ".";
							}
							if (j + 1 < R) {
								arr[i][j + 1][k] = ".";
							}
							if (k + 1 < C) {
								arr[i][j][k + 1] = ".";
							}
						}
					}
				}
			}
		}

		printArr(R, C, N);

	}

	public static void printArr(int R, int C, int index) {
		String result = "";

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result += arr[index][i][j];
			}
			result += "\n";
		}

		System.out.println(result);
	}

	public static void makeO(int R, int C, int index) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				arr[index][i][j] = "O";
			}
		}
	}
}
