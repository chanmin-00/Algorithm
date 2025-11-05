import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {

	// 구하고자 하는 것 -> N일까지 일했을 때 최대 수익
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine()); // 상담을 해야 하는 날짜 개수
		int[] tArr = new int[N + 1];
		int[] pArr = new int[N + 1];
		long[] dp = new long[N * 5];

		for (int i = 1; i <= N; i++) {
			String[] input = reader.readLine().split(" ");

			tArr[i] = Integer.parseInt(input[0]);
			pArr[i] = Integer.parseInt(input[1]);
		}

		for (int i = 1; i <= N; i++) {
			int day = i + tArr[i] - 1;

			dp[day] = Math.max(dp[day], dp[day - tArr[i]] + pArr[i]);

			for (int j = day - tArr[i]; j < day; j++) {
				dp[j] = Math.max(dp[j], dp[day - tArr[i]]);
			}

			// System.out.println(day);
			// System.out.println(dp[day]);
		}

		long max = -1;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}
}
