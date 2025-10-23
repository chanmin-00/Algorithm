import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] P = new int[N + 1];
		int[] C = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			P[i] = sc.nextInt();
			C[i] = sc.nextInt();
		}

		int[][] dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (C[i] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - C[i]] + P[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		int maxPreference = 0;
		for (int j = 0; j <= M; j++) {
			maxPreference = Math.max(maxPreference, dp[N][j]);
		}

		if (maxPreference == 0) {
			System.out.println(-1);
		} else {
			List<Integer> selectedCourses = new ArrayList<>();
			int i = N, j = M;
			while (i > 0) {
				if (dp[i][j] != dp[i - 1][j]) {
					selectedCourses.add(i);
					j -= C[i];
				}
				i--;
			}

			System.out.println(selectedCourses.size());
			Collections.sort(selectedCourses);
			for (int courseNo : selectedCourses) {
				System.out.print(courseNo + " ");
			}
		}
	}

}


