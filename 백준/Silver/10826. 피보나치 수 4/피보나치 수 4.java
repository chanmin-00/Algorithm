import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		String[] dp = new String[10001];

		dp[0] = "0";
		dp[1] = "1";

		for (int i = 2; i <= n; i++) {
			dp[i] = add(dp[i - 2], dp[i - 1]);
			// System.out.println(dp[i]);
		}

		System.out.println(dp[n]);
	}

	public static String add(String num1, String num2) {
		// num2이 더 큰수
		int prevAdd = 0;
		String result = "";

		for (int i = 0; i < num1.length(); i++) {
			int char1 = Integer.parseInt(num1.charAt(num1.length() - i - 1) + "");
			int char2 = Integer.parseInt(num2.charAt(num2.length() - i - 1) + "");

			int value = char1 + char2 + prevAdd;

			if (value > 9) {
				int rear = value % 10;
				prevAdd = value / 10;

				result = rear + result;
			} else {
				int rear = value % 10;
				prevAdd = 0;

				result = rear + result;
			}
		}

		for (int i = num1.length(); i < num2.length(); i++) {
			int char2 = Integer.parseInt(num2.charAt(num2.length() - i -1) + "");

			int value = char2 + prevAdd;

			if (value > 9) {
				int rear = value % 10;
				prevAdd = value / 10;

				result = rear + result;
			} else {
				int rear = value % 10;
				prevAdd = 0;

				result = rear + result;
			}
		}

		if (prevAdd != 0) {
			result = prevAdd + result;
		}

		return result;
	}
}
