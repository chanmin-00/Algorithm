import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 연속적인 K일 온도의 합이 최대가 되는 경우
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int N = Integer.parseInt(input[0]); // 온도를 측정한 전체 날짜의 수
		int K = Integer.parseInt(input[1]); // 합을 구하기 위한 연속적인 날짜의 수

		int[] arr = new int[N];

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int sum = 0;
		int max = Integer.MIN_VALUE;
		int frontIndex = 0;
		int rearIndex = K - 1;

		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}

		if (sum > max) {
			max = sum;
		}

		for (int i = 1; i + K <= N; i++) {
			int num1 = arr[frontIndex];
			int num2 = arr[rearIndex + 1];

			sum = sum - num1;
			sum = sum + num2;

			if (sum > max) {
				max = sum;
			}

			frontIndex++;
			rearIndex++;
		}

		System.out.print(max);
	}

}
