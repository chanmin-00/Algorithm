import java.io.*;
import java.util.*;

// 제일 뒤로 보내거나 앞으로 보내는 2가지 경우의 수가 있다.
// 현재 단계에서 할 수 있는 선택지
// n명 중 1개를 선택해서 제일 앞으로 보내거나 뒤로 보낸다.

// 가장 길게 정렬되어 있는 애를 찾고,
// 나머지 정렬이 되지 않은 것들만 내가 원하는 순서대로 옮기면 된다.
// 옮기기 위해서 움직여야 할 것들은 내 맘대로 선택할 수 있기 때문
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] arr;
	static int[] dp;
	static String[] input;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(reader.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1];

		input = reader.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i + 1] = Integer.parseInt(input[i]);
		}

		int maxLen = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			int num = arr[i];
			dp[num] = dp[num - 1] + 1;

			maxLen = Math.max(maxLen, dp[num]);
		}

		System.out.println(n - maxLen);

	}
}
