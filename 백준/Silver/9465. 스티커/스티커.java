import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(reader.readLine()); // 테스트 케이스의 개수

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine()); // 열 값

			int[][] arr = new int[2][n]; // 점수 정보를 가지고 있는 2차원 배열

			for (int j = 0; j < 2; j++) {
				String[] input = reader.readLine().split(" ");

				for (int k = 0; k < n; k++) {
					arr[j][k] = Integer.parseInt(input[k]);
				}
			}

			int[][] dp = new int[2][n]; // 해당 인덱스를 포함했을 때의 점수 최대 정보를 저장함.
			int[] dp_1 = new int[n]; // 각 열을 지날 때마다 각 열에서의 점수 최대 정보를 저장함

			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp_1[0] = Math.max(dp[0][0], dp[1][0]);

			for (int j = 1; j < n; j++) {
				if (j == 1) {
					dp[0][1] = dp[1][0] + arr[0][1];
					dp[1][1] = dp[0][0] + arr[1][1];
					dp_1[1] = Math.max(dp[0][1], dp[1][1]);
				} else {
					int val1 = dp[1][j - 1] + arr[0][j];
					int val2 = dp_1[j - 2] + arr[0][j];
					dp[0][j] = Math.max(val1, val2);

					val1 = dp[0][j - 1] + arr[1][j];
					val2 = dp_1[j - 2] + arr[1][j];
					dp[1][j] = Math.max(val1, val2);

					dp_1[j] = Math.max(dp[0][j], dp[1][j]);
				}
			}

			System.out.println(dp_1[n - 1]);
		}
	}
}
