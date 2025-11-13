import java.io.*;
import java.util.*;

// 0은 갈 수 없는 땅
// 1은 출발 지점
// 2은 목표 지점
// 반대로 생각해보면 2에서 시작해서 1까지 얼마나 최소로 갈 수 있나 생각해보면 됨
// 즉, 2를 출발 지점으로 잡아보자
public class Main {

	static String[] input;

	static int[] dx = new int[] {-1, 0, 1, 0};
	static int[] dy = new int[] {0, -1, 0, 1};

	static class Node {
		int i;
		int j;
		int depth;

		public Node(int i, int j, int depth) {
			this.i = i;
			this.j = j;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		input = reader.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // 행
		int m = Integer.parseInt(input[1]); // 열

		int[][] arr = new int[n + 1][m + 1];
		int[][] result = new int[n + 1][m + 1];
		boolean[][] visited = new boolean[n + 1][m + 1];

		int startI = 0;
		int startJ = 0;

		for (int i = 1; i <= n; i++) {
			input = reader.readLine().split(" ");

			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(input[j - 1]);

				if (arr[i][j] == 2) {
					startI = i;
					startJ = j;
				}
			}
		}

		Queue<Node> bfsQueue = new LinkedList<>();
		bfsQueue.offer(new Node(startI, startJ, 0));
		visited[startI][startJ] = true;

		while (!bfsQueue.isEmpty()) {
			Node node = bfsQueue.poll();

			int i = node.i;
			int j = node.j;
			int depth = node.depth;

			for (int k = 0; k < 4; k++) {
				int nextI = i + dx[k];
				int nextJ = j + dy[k];

				if ((nextI >= 1 && nextI <= n) && (nextJ >= 1 && nextJ <= m)) {
					if (visited[nextI][nextJ] == true) {
						continue;
					}

					if (arr[nextI][nextJ] != 0) {
						Node newNode = new Node(nextI, nextJ, depth + 1);
						bfsQueue.offer(newNode);

						visited[nextI][nextJ] = true;

						result[nextI][nextJ] = depth + 1;
					}
				}
			}
		}

		StringBuilder resultStr = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] == 1 && result[i][j] == 0) {
					resultStr.append("-1 ");
				} else {
					resultStr.append(result[i][j] + " ");
				}
			}
			resultStr.append("\n");
		}

		System.out.println(resultStr);

	}

}
