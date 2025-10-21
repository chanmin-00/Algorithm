import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	// 사이클이 없는 그래프 -> 트리?
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 1;
		while (true) {
			int input = Integer.parseInt(reader.readLine());

			if (input == 0) {
				return;
			}

			int[][] arr = new int[input][3];
			int[] dp = new int[input * 3];

			for (int i = 0; i < input; i++) {
				String[] tmp = reader.readLine().split(" ");
				dp[i * 3 + 0] = 1000000;
				dp[i * 3 + 1] = 1000000;
				dp[i * 3 + 2] = 1000000;

				arr[i][0] = Integer.parseInt(tmp[0]);
				arr[i][1] = Integer.parseInt(tmp[1]);
				arr[i][2] = Integer.parseInt(tmp[2]);
			}

			dp[0] = arr[0][1];
			dp[1] = arr[0][1];

			Queue<Integer> queue = new LinkedList<>();
			queue.offer(0 * 3 + 1);

			while (!queue.isEmpty()) {
				int value = queue.poll();

				int row = value / 3;
				int col = value % 3;

				int newRow;
				int newCol;

				if (col == 0) {

					newRow = (row + 1);
					newCol = col;
					if (newRow < input) {

						if (dp[newRow * 3 + newCol] > (dp[value] + arr[newRow][newCol])) {
							queue.offer(newRow * 3 + newCol);
							dp[newRow * 3 + newCol] = dp[value] + arr[newRow][newCol];
						}
					}

					newRow = row;
					newCol = col + 1;
					if (newCol < 3) {

						if (dp[newRow * 3 + newCol] > (dp[value] + arr[newRow][newCol])) {
							queue.offer(newRow * 3 + newCol);
							dp[newRow * 3 + newCol] = dp[value] + arr[newRow][newCol];
						}
					}

					newRow = row + 1;
					newCol = col + 1;
					if (newCol < 3 && newRow < input) {

						if (dp[newRow * 3 + newCol] > (dp[value] + arr[newRow][newCol])) {
							queue.offer(newRow * 3 + newCol);
							dp[newRow * 3 + newCol] = dp[value] + arr[newRow][newCol];
						}
					}

				}

				if (col == 1) {

					newRow = row + 1;
					newCol = col - 1;
					if (newRow < input && newCol > -1) {

						if (dp[newRow * 3 + newCol] > (dp[value] + arr[newRow][newCol])) {
							queue.offer(newRow * 3 + newCol);
							dp[newRow * 3 + newCol] = dp[value] + arr[newRow][newCol];
						}
					}

					newRow = row + 1;
					newCol = col;
					if (newRow < input) {

						if (dp[newRow * 3 + newCol] > (dp[value] + arr[newRow][newCol])) {
							queue.offer(newRow * 3 + newCol);
							dp[newRow * 3 + newCol] = dp[value] + arr[newRow][newCol];
						}
					}

					newRow = row + 1;
					newCol = col + 1;
					if (newCol < 3 && newRow < input) {

						if (dp[newRow * 3 + newCol] > (dp[value] + arr[newRow][newCol])) {
							queue.offer(newRow * 3 + newCol);
							dp[newRow * 3 + newCol] = dp[value] + arr[newRow][newCol];
						}
					}

					newRow = row;
					newCol = col + 1;
					if (newCol < 3) {

						if (dp[newRow * 3 + newCol] > (dp[value] + arr[newRow][newCol])) {
							queue.offer(newRow * 3 + newCol);
							dp[newRow * 3 + newCol] = dp[value] + arr[newRow][newCol];
						}
					}

				}

				if (col == 2) {

					newRow = row + 1;
					newCol = col - 1;
					if (newRow < input && newCol > -1) {

						if (dp[newRow * 3 + newCol] > (dp[value] + arr[newRow][newCol])) {
							queue.offer(newRow * 3 + newCol);
							dp[newRow * 3 + newCol] = dp[value] + arr[newRow][newCol];
						}
					}

					newRow = row + 1;
					newCol = col;
					if (newRow < input) {

						if (dp[newRow * 3 + newCol] > (dp[value] + arr[newRow][newCol])) {
							queue.offer(newRow * 3 + newCol);
							dp[newRow * 3 + newCol] = dp[value] + arr[newRow][newCol];
						}

					}
				}

			}

			System.out.println(cnt + ". " + dp[(input - 1) * 3 + 1]);
			cnt++;

		}
	}
}