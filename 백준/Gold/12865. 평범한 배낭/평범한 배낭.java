import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = reader.readLine().split(" ");

		int n = Integer.parseInt(inputArr[0]); // 물품의 수
		int k = Integer.parseInt(inputArr[1]); // 준서가 버틸 수 있는 무게, K
		int[] dp = new int[k + 1]; // dp[w] = value -> w에서의 최대 가치 정보를 저장하자.

		int[] wArr = new int[n + 1]; // 각 물품의 무게 정보 배열
		int[] vArr = new int[n + 1]; // 각 물품의 가치 정보 배열

		for (int i = 1; i <= n; i++) {
			inputArr = reader.readLine().split(" ");

			wArr[i] = Integer.parseInt(inputArr[0]); // 무게
			vArr[i] = Integer.parseInt(inputArr[1]); // 가치
		}

		for (int i = 1; i <= n; i++) {
			for (int j = k; j >= wArr[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - wArr[i]] + vArr[i]);
			}
		}

		System.out.println(dp[k]);

	}
}

