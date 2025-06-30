import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 표준 입력

		int n = Integer.parseInt(reader.readLine());
		long[][] dp = new long[n][3];

		dp[0][0] = 1; // 아무것도 안 놓는 경우
		dp[0][1] = 1; // 왼쪽에만 놓는 경우
		dp[0][2] = 1; // 오른쪽에만 놓는 경우

		for (int i = 1; i < n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901; // 아무것도 안 놓는 경우
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901; // 왼쪽에만 놓는 경우
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901; // 오른쪽에만 놓는 경우
		}

		long result = (dp[n-1][0] + dp[n-1][1] + dp[n-1][2]) % 9901;

		System.out.println(result);

	}
}
