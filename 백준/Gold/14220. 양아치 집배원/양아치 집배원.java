import java.io.*;
import java.lang.*;

public class Main {

	// 영선, 한 도시 방문 -> 다른 도시 방문
	// 잘못 방문하더라도 방문한 또 다시 방문하기도 함
	// 이동한 거리가 최소로 방문했다고 함
	// 도시 n개를 모두 방문하는게 아니라 n번 방문했다고 하는 것
	// 구하고자 하는 것: n번 방문했을 때 최소 이동거리
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine()); // 방문하는 도시 개수 n
		int[][] arr = new int[n + 1][n + 1];
		long[][] dp = new long[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			String[] input = reader.readLine().split(" ");

			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(input[j - 1]);
				dp[i][j] = Integer.MAX_VALUE;

			}

		}

		for (int k = 1; k < n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][j] != 0) {
						dp[k][j] = Math.min(dp[k - 1][i] + arr[i][j], dp[k][j]);
					}

				}
			}
		}

		long min = Long.MAX_VALUE;
		boolean flag = false;

		for (int k = 1; k <= n; k++) {
			if (dp[n - 1][k] != Integer.MAX_VALUE) {
				flag = true;
			}
			min = Math.min(min, dp[n - 1][k]);

		}

		if (flag) {
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}

}
