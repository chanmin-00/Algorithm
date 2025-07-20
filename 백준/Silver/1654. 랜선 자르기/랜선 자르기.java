import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	/**
	 * 이미 가지고 있는 랜선을 붙일 수는 없고, 잘라서 만들어야 한다.
	 * 구하고자 하는 것은, n개를 만들 수 있는 랜선의 최대 길이를 구하느 것이다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = reader.readLine().split(" ");

		int k = Integer.parseInt(input[0]); // 오영식이 이미 가지고 있는 랜선의 개수
		int n = Integer.parseInt(input[1]); // 필요한 랜선의 개수, 모두 같은 길이의 랜선이 n개 만들어져야 한다.
		long[] kArr = new long[k];

		for (int i = 0; i < k; i++) {
			long num = Long.parseLong(reader.readLine());
			kArr[i] = num;
		}

		Arrays.sort(kArr); // 내림차순으로 정렬한다.

		long front = 1;
		long rear = kArr[k - 1];
		long middle;
		long result = 0;

		// 제일 작은 것을 기준으로 이분탐색을 진행할 것이다.
		while (front <= rear) {
			middle = (front + rear) / 2; // 정수 최대 + 정수 최대를 더하면 오버플로 문제가 발생할 수 있다.

			long sum = 0;
			for (int i = 0; i < k; i++) {
				sum += kArr[i] / middle;
			}

			// 이분 탐색에서는 범위를 -1, +1로 줄여나가야 한다.
			if (sum < n) {
				rear = middle - 1; // 조건을 만족하지 않기 때문에, middle 보다 작은 구간부터 검사를 한다.
			} else { // 조건을 만족한 경우
				front = middle + 1; // 만족했지만 최대 길이를 구하기 위해 더 긴 길이도 가능한지 확인을 해야 한다.
				result = middle;
			}
		}

		System.out.println(result);
	}
}
