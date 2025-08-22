import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 합이 N이 되기 위한 경우의 수가 몇개인가? -> 정수 K개를 써서
	// 재귀 호출을 하면 쉽게 풀리겠지만, 시간초과가 발생할 것 같다
	// 재귀를 DP로 바꿔서 풀어야 될 것 같다
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]); // 정수 K개
		int[][] arr = new int[K + 1][N + 1];

		for (int i = 0; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				arr[i][j] = 0;
			}
		}

		for (int i = 0; i <= K; i++) {
			arr[i][0] = 1; // 정수 i개를 더할 때, 0이 되기 위한 경우의 수
		}
		for (int i = 0; i <= N; i++) {
			arr[1][i] = 1; // 정수 1개를 더할 때, i가 되기 위한 경우의 수
		}

		for (int i = 2; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				// 정수 i개를 더할 때 j가 되기 위한 경우의 수
				// 정수 i-1개를 더하고 k개가 되는 경우의 수가 있다. 마지막에 0만 추가해주면 된다.
				// 정수 i개를 더하고 j-1이 되는 경우가 있다. 이 경우 마지막 수를 빼서 +1로 교체하면 된다.
				arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % 1000000000;

			}
		}

		System.out.println(arr[K][N]);
	}
}