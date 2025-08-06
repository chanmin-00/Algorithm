import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int c = Integer.parseInt(reader.readLine());
		int[][] position = new int[11][11];

		for (int i = 0; i < c; i++) {
			max = 0;
			boolean[] usedPosition = new boolean[11]; // 해당 반복문에서 이미 사용된 포지션인지 확인하는 배열

			for (int j = 0; j < 11; j++) {
				input = reader.readLine().split(" ");
				for (int k = 0; k < 11; k++) {
					position[j][k] = Integer.parseInt(input[k]);
				}
			}

			backtrack(position, usedPosition, 0, 0);

			System.out.println(max);
		}

	}

	public static void backtrack(int[][] position, boolean[] usedPosition, int nowIndex, int value) {
		if (nowIndex == 11) {
			if (max < value) {
				max = value;
			}
			return;
		}

		for (int i = 0; i < 11; i++) { // 각 행에서의 각 열 탐색하기 위함
			if (usedPosition[i]) {
				continue;
			}

			if (position[nowIndex][i] > 0) {

				usedPosition[i] = true; // i번째 포지션을 true로 변경, 현재 방문하고 있음을 나타냄
				value += position[nowIndex][i];

				backtrack(position, usedPosition, nowIndex + 1, value);

				value -= position[nowIndex][i];
				usedPosition[i] = false; // i번째 포지션을 false로 변경, 현재 레벨에서 방문을 끝냈음을 의미
			}
		}
	}
}
