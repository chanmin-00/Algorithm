import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = reader.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // 영토의 크기, 행
		int m = Integer.parseInt(input[1]); // 영토의 크기, 열
		int t; // 테스트 케이스의 개수
		int[][] people = new int[n + 1][m + 1]; // 사람 수를 저장하고 있는 배열
		int[][] prefixSum; // 해당 좌표까지의 누적합 정보를 담고 있는 배열

		for (int i = 1; i <= n; i++) {
			input = reader.readLine().split(" ");
			for (int j = 1; j <= m; j++) {
				people[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		prefixSum = getPrefixSum(people, n, m);

		t = Integer.parseInt(reader.readLine());

		for (int i = 0; i < t; i++) {
			int result = 0;
			int x1, y1;
			int x2, y2;

			input = reader.readLine().split(" ");
			x1 = Integer.parseInt(input[0]);
			y1 = Integer.parseInt(input[1]);
			x2 = Integer.parseInt(input[2]);
			y2 = Integer.parseInt(input[3]);

			result = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];

			System.out.println(result);
		}

	}

	public static int[][] getPrefixSum(int[][] people, int n, int m) {
		int[][] prefixSum = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {

				if (i == 0 || j == 0) {
					prefixSum[i][j] = 0;
				} else {
					prefixSum[i][j] = people[i][j];
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				prefixSum[i][j] += prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
			}
		}

		return prefixSum;
	}
}
