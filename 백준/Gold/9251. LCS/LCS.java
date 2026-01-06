import java.io.*;
import java.util.*;

// 구하고자 하는 것 : 가장 큰 공통 부분 수열 문제
//
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String str1;
	static String str2;
	static int[][] dp;
	static int answer = 0;

	// 최장 공통 부분 수열을 찾는 문제

	public static void main(String[] args) throws IOException {

		str1 = reader.readLine();
		str2 = reader.readLine();

		dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				// 1. str1의 i번째와 str2의 j번째를 비교했을 경우, 문자열이 같은 경우
				// 두 문자가 같으면 각자 전의 인덱스까지 고려한 거에 +1을 해주면 된다.

				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				// 2. str1의 i번째와 str2의 j번째를 비교했을 경우, 문자열이 다른 경우
				// i - 1, j 번째 비교, i, j - 1 번째 비교한 것중 최대값을 고른다.
				//
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

				answer = Math.max(dp[i][j], answer);
			}
		}

		System.out.println(answer);

	}
}
