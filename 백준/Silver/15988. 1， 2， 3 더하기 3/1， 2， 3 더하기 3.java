import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(reader.readLine());

		long[] dp = new long[1000001];
		dp[1] = 1L;
		dp[2] = 2L;
		dp[3] = 4L;

		for (int i = 4; i <= 1000000; i++) {
			dp[i] = 0L;

			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
		}

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(reader.readLine());

			System.out.println(dp[n]);
		}

	}
}
