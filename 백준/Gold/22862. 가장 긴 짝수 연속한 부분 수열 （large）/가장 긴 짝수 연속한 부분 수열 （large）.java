import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 무조건 홀수를 삭제해야 함
	// 어떤 구간을 잡았을 때, 그 구간의 홀수 개수가 K이하 개이면 k개를 삭제하면 모두 짝수가 연속된 수열이 됨
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		int[] arr = new int[N];
		input = reader.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int oddCnt = 0; // 특정 구간 내의 홀수의 개수
		int result = 0; // 결과값
		int left = 0;
		int right = 0;

		for (right = 0; right < N; right++) {
			if (arr[right] % 2 == 1) {
				oddCnt++;
			}

			while (oddCnt > K) { // 구간내의 홀수 개수가 K보다 많으면 안됨
				if (arr[left] % 2 == 1) {
					oddCnt--;
				}
				left++;
			}

			int val = right - left + 1 - oddCnt;
			result = Math.max(result, val);
		}

		System.out.println(result);

	}
}
