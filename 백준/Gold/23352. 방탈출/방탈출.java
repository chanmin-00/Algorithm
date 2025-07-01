import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int n, m;
	static int[][] arr;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] inputArr = reader.readLine().split(" ");
		n = Integer.parseInt(inputArr[0]);
		m = Integer.parseInt(inputArr[1]);

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			inputArr = reader.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(inputArr[j]);
			}
		}

		int maxDistance = -1;
		int maxSum = 0;

		// 모든 좌표에 대해 BFS 실행
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0)
					continue;

				int[][] visited = new int[n][m];
				Queue<int[]> queue = new LinkedList<>();

				queue.offer(new int[] {i, j});
				visited[i][j] = 1;

				while (!queue.isEmpty()) {
					int[] cur = queue.poll();
					int x = cur[0], y = cur[1];

					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];

						if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
							if (visited[nx][ny] == 0 && arr[nx][ny] != 0) {
								visited[nx][ny] = visited[x][y] + 1;
								queue.offer(new int[] {nx, ny});

								int dist = visited[nx][ny] - 1;
								int sum = arr[i][j] + arr[nx][ny];

								if (dist > maxDistance) {
									maxDistance = dist;
									maxSum = sum;
								} else if (dist == maxDistance) {
									maxSum = Math.max(maxSum, sum);
								}
							}
						}
					}
				}
			}
		}

		System.out.println(maxSum);
	}
}
