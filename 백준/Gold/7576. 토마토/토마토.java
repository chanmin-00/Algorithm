import java.io.*;
import java.util.*;

// 1의 값이 여러 개 존재할 경우 어떻게 대처할 것인가?
// 큐에 첫 시작 값을 여러 개 넣어놓으면 된다.
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static class Node {
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
		input = reader.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		arr = new int[M + 1][N + 1];
		visited = new boolean[M + 1][N + 1];

		Queue<Node> que = new LinkedList<>();

		int totalTomatoCnt = 0;
		int tomatoCnt = 0;
		int min = 0;

		for (int i = 1; i <= M; i++) {
			input = reader.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(input[j - 1]);

				if (arr[i][j] == 1 || arr[i][j] == 0) {
					totalTomatoCnt++;
				}

				if (arr[i][j] == 1) { // 익은 토마토의 경우
					que.offer(new Node(i, j, 0));
					visited[i][j] = true;
					tomatoCnt++;
				}
			}
		}

		// System.out.println("yes");

		if (totalTomatoCnt == tomatoCnt) {
			System.out.println(0);
			return;
		}

		while (!que.isEmpty()) {
			Node current = que.poll();
			int i = current.i;
			int j = current.j;
			int depth = current.depth;

			// System.out.println(" i" + i  + " j" + j) ;

			for (int index = 0; index < 4; index++) {
				int newI = i + dx[index];
				int newJ = j + dy[index];
				int newDepth = depth + 1;

				if (newI >= 1 && newI <= M && newJ >= 1 && newJ <= N && visited[newI][newJ] == false) {
					if (arr[i][j] == 1 && arr[newI][newJ] == 0) {
						arr[newI][newJ] = 1;
						visited[newI][newJ] = true;
						tomatoCnt++;

						que.offer(new Node(newI, newJ, newDepth));
						min = Math.max(min, newDepth);
					}
				}
			}
		}

		if (totalTomatoCnt == tomatoCnt) {
			System.out.println(min);
		}
		else {
			System.out.println(-1);
		}

	}
}
