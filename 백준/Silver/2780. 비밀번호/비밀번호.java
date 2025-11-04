import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 구하고자 하는 것은 N일 때 비밀번호의 개수
	// 그러면 N일 때의 비밀번호 개수는
	// dp[N] = dp[N-1] +
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(reader.readLine());
		int[][] dp = new int[1001][10];

		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= 1000; i++) {
			dp[i][1] = (dp[i - 1][4] + dp[i - 1][2]) % 1234567;
			dp[i][2] = (dp[i - 1][1] + dp[i - 1][5] + dp[i - 1][3]) % 1234567;
			dp[i][3] = (dp[i - 1][2] + dp[i - 1][6]) % 1234567;

			dp[i][4] = (dp[i - 1][1] + dp[i - 1][7] + dp[i - 1][5]) % 1234567;
			dp[i][5] = (dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][6] + dp[i - 1][8]) % 1234567;
			dp[i][6] = (dp[i - 1][3] + dp[i - 1][5] + dp[i - 1][9]) % 1234567;

			dp[i][7] = (dp[i - 1][4] + dp[i - 1][8] + dp[i - 1][0]) % 1234567;
			dp[i][8] = (dp[i - 1][5] + dp[i - 1][7] + dp[i - 1][9]) % 1234567;
			dp[i][9] = (dp[i - 1][6] + dp[i - 1][8]) % 1234567;
			dp[i][0] = dp[i - 1][7] % 1234567;
		}

		// 2 + 3 + 2 + 3 + 4+ 3 + 3 + 3 + 2 + 1 = 26
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(reader.readLine()); // 비밀번호의 길이 N
			int sum = 0;

			for (int j = 0; j <= 9; j++) {
				sum = (sum + dp[N][j]) % 1234567;
			}

			System.out.println(sum);
		}
	}
}
