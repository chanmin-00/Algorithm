import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine()); // n개의 정수로 이루어진 수열
		int[] arr = new int[n + 1];
		long[] sum = new long[n + 1];
		long[] exceptSum = new long[n + 1];

		String[] input = reader.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i + 1] = Integer.parseInt(input[i]);
		}

		long max = arr[1];

		sum[1] = arr[1];
		exceptSum[1] = 0;

		for (int i = 2; i <= n; i++) {

			// 1. 지금까지 올 때 아직 안 뺀 경우

			// 1.1 지금 현재의 경우도 안 뺄거다.
			// 더 작아지면 현재값부터 다시 시작,
			sum[i] = Math.max(sum[i - 1] + arr[i], arr[i]);

			// 1.2 지금 현재의 경우에서 빼겠다.
			exceptSum[i] = sum[i - 1];

			// 2. 이미 그 전에 제외시킨 경우
			exceptSum[i] = Math.max(exceptSum[i], exceptSum[i - 1] + arr[i]);

			if (max < sum[i]) {
				max = sum[i];
			}
			if (max < exceptSum[i]) {
				max = exceptSum[i];
			}
		}

		System.out.println(max);
	}

}
