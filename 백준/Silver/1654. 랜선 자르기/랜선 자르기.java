import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	public static void main(String[] args) throws IOException {
		input = reader.readLine().split(" ");

		int K = Integer.parseInt(input[0]); // 오영식이 이미 가지고 있는 랜선의 개수
		int N = Integer.parseInt(input[1]); // 필요한 랜선의 개수

		int[] arr = new int[K];

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}

		Arrays.sort(arr);

		long left = 1;
		long right = arr[K - 1];
		long mid = 0;
		long answer = 0;

		while (left <= right) {
			// System.out.println("left : " + left + " right " + right);

			mid = (left + right) / 2;
			long cnt = 0;

			for (int i = 0; i < K; i++) {
				cnt += (arr[i] / mid);
			}

			if (cnt >= N) { // 이 경우에는 자르는 랜선의 길이를 좀 늘려야 함
				left = mid + 1;
				if (answer == mid) {
					break;
				}
				answer = Math.max(answer, mid);
			} else if (cnt < N) { //  이 경우에는 자르는 랜선의 길이를 좀 줄여야 함
				right = mid - 1;
			}
		}

		System.out.println(answer);

	}
}
