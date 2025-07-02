import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n, m; // 행/열
		int testCnt; // 테스트 개수

		String[] inputArr = reader.readLine().split(" ");
		n = Integer.parseInt(inputArr[0]);
		m = Integer.parseInt(inputArr[1]);

		int[][] arr = new int[n + 1][m + 1];
		int[][] prefixSumArr = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			inputArr = reader.readLine().split(" ");
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(inputArr[j - 1]);
			}
		}

		// 1. 전체 배열을 통해서 우선적으로 누적합 배열을 구해야 함.
		getPrefixSum(arr, prefixSumArr, n, m);

		testCnt = Integer.parseInt(reader.readLine());

		// 2. 누적합 배열을 활용해 특정 부분에서의 배열의 합을 구해야 함
		for (int t = 0; t < testCnt; t++) {
			inputArr = reader.readLine().split(" ");
			int i = Integer.parseInt(inputArr[0]);
			int j = Integer.parseInt(inputArr[1]);
			int x = Integer.parseInt(inputArr[2]);
			int y = Integer.parseInt(inputArr[3]);

			int returnVal = getPartialPrefixSum(prefixSumArr, i, j, x, y);

			System.out.println(returnVal);
		}

	}

	public static void getPrefixSum(int[][] arr, int[][] prefixSumArr, int n, int m) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int ni = i - 1;
				int nj = j - 1;

				prefixSumArr[i][j] = 0;

				prefixSumArr[i][j] += prefixSumArr[ni][j];
				prefixSumArr[i][j] += prefixSumArr[i][nj];

				prefixSumArr[i][j] -= prefixSumArr[ni][nj];

				prefixSumArr[i][j] += arr[i][j];
			}
		}
	}

	public static int getPartialPrefixSum(int[][] prefixSumArr, int i, int j, int x, int y) {
		int result = 0;

		result += prefixSumArr[x][y];

		result -= prefixSumArr[i - 1][y];

		result -= prefixSumArr[x][j - 1];

		result += prefixSumArr[i - 1][j - 1];

		return result;
	}

}
