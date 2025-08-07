import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 구하고자 하는 값은 n킬로그램을 배달해야 할 때, 봉지 몇 개를 가져가야 하는가?
	// 봉지는 3킬로그램과 5킬로그램으로 나뉘어짐
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine()); // n킬로그램
		int[] dp = new int[n + 1]; // n킬로그램을 배달해야 할 때의 봉지 최소 개수 정보 저장
		for (int i = 0; i <= n; i++) {
			dp[i] = -1;
		}

		dp[3] = 1;
		if (n > 4) {
			dp[5] = 1;
		}

		for (int i = 3; i <= n; i++) {
			for (int j = 3; j < i; j++) {
				if (dp[j] != -1 && dp[i - j] != -1) {
					if (dp[i] == -1) {
						dp[i] = dp[j] + dp[i - j];
					} else {
						dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
					}
				}
			}

		}

		System.out.println(dp[n]);
	}
}
