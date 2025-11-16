import java.io.*;
import java.util.*;

// 최소 이동 횟수를 구해야 하기 때문에 bfs
// 큐에 먼저 들어오는게 더 짧은 거리에 해당함
public class Main {

	static String[] input;

	static int N;
	static int[][] arr;

	static int[] dx = {-2, -2, 0, 0, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -1, 1};

	static class Node {
		int i;
		int j;
		int cnt;

		public Node(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(reader.readLine());
		arr = new int[N][N];

		input = reader.readLine().split(" ");

		int r1 = Integer.parseInt(input[0]);
		int c1 = Integer.parseInt(input[1]);
		int r2 = Integer.parseInt(input[2]);
		int c2 = Integer.parseInt(input[3]);

		boolean[][] visited = new boolean[N][N];

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r1, c1, 0));

		visited[r1][c1] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (node.i == r2 && node.j == c2) {
				System.out.println(node.cnt);
				return;
			}

			for (int i = 0; i < 6; i++) {
				int newI = node.i + dx[i];
				int newJ = node.j + dy[i];

				if (newI >= 0 && newI < N && newJ >= 0 && newJ < N && !visited[newI][newJ]) {
					visited[newI][newJ] = true;
					queue.offer(new Node(newI, newJ, node.cnt + 1));
				}
			}
		}

		System.out.println(-1);

	}
}
