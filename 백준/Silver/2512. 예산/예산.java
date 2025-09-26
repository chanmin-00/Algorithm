import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int N = Integer.parseInt(reader.readLine()); // 지방의 수
		int[] arr = new int[N]; // 예산 배열
		int cost; // 총 예산
		int sum = 0;
		int result;

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
			sum += arr[i];
		}

		cost = Integer.parseInt(reader.readLine());
		Arrays.sort(arr);

		if (sum <= cost) {
			result = arr[N - 1];
		} else {
			int right = cost;
			int left = 1;
			int mid = (right + left) / 2;
			int prevMid = mid;

			while (left <= right) {
				prevMid = mid;
				mid = (right + left) / 2;

				// System.out.println("right : " + right);
				// System.out.println("left : " + left);
				// System.out.println("mid : " + mid);

				int tmpSum = 0;

				for (int i = 0; i < N; i++) {
					if (mid < arr[i]) {
						tmpSum += mid;
					} else {
						tmpSum += arr[i];
					}
				}

				if (tmpSum > cost) {
					right = mid - 1;
					mid = prevMid;
				}
				else {
					left = mid + 1;
				}
			}

			result = mid;
		}

		System.out.println(result);

	}
}
