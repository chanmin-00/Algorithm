import java.io.*;
import java.util.*;

// 구하고자 하는 것 : 길이가 N인 수열 중, 가장 길이가 긴 증가하는 부분 수열
public class Main {

	static String[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N]; // 나를 포함해서 현재 나의 뒤에 나보다 작은 것의 개수

		int maxI = 0;
		String str = "";

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
			dp[i] = 1;
		}

		int result = 1;

		for (int i = 1; i < N; i++) {

			for (int j = 0; j < i; j++) {

				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}

			result = Math.max(dp[i], result);

			if (result == dp[i]) {
				maxI = i;
			}
		}

		System.out.println(result);
		str = arr[maxI] + "";

		while (dp[maxI] != 1) {
			for (int i = maxI - 1; i > -1; i--) {
				if (dp[maxI] - 1 == dp[i] && arr[i] < arr[maxI]) {
					str = arr[i] + " " + str;
					maxI = i;
					break;
				}
			}
		}

		System.out.println(str);

	}
}
