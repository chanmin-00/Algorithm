import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] input = reader.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // n번째 행
		int k = Integer.parseInt(input[1]); // k번째 수

		int[][] pascal = new int[31][31];

		for (int i = 1; i <= n; i++) {
			pascal[i][1] = 1;
			pascal[i][i] = 1;
		}

		pascal[2][1] = 1;

		for (int i = 2; i <= n; i++) {

			for (int j = 2; j < i; j++) {
				pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
			}
		}

		System.out.println(pascal[n][k]);
	}


}
