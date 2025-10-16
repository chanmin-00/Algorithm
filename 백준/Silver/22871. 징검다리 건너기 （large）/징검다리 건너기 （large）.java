import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 경로 상의 구간 간격의 최댓값의 최소를 구하면 되는 것
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine()); // 돌의 개수
		long[] arr = new long[N]; // 돌의 수 배열
		long[] dp = new long[N];

		String[] input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		dp[0] = 0;

		for (int i = 1; i < N; i++) {
			long min = Long.MAX_VALUE;

			for (int j = 0; j < i; j++) {
				long tmp = (i - j) * (1L + Math.abs(arr[i] - arr[j]));

				long val = Math.max(dp[j], tmp);

				if (val <= min) {
					min = val;
				}
			}

			dp[i] = min;
		}

		System.out.println(dp[N - 1]);
	}
}
