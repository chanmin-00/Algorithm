import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	static class Node {
		int index;
		int value; // 내 가중치 + 이전 가중치 정보를 다 더함

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int n; // 동굴의 크기, 0이 주어지면 테스트를 종료한다.
		int cnt = 1;

		while (true) {
			n = Integer.parseInt(reader.readLine());

			if (n == 0) {
				break;
			}

			// (0,0)의 위치에서 (n-1, n-1)의 위치까지 최소 비용을 잃으면서 이동해야 한다.
			// 가장 빠 시간 내에 이동해야 하는 것이 아니라, 최소 비용을 잃으면서 가야 하는 것.
			// (0,0) -> (n-1, n-1)
			int[][] cave = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			int[][] result = new int[n][n];

			Queue<Node> queue = new PriorityQueue<>((n1, n2) -> {
				return n1.value - n2.value;
			});

			for (int i = 0; i < n; i++) {
				input = reader.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					cave[i][j] = Integer.parseInt(input[j]);
				}
			}

			queue.offer(new Node(0, cave[0][0])); // 우선순위가 가장 높은 value가 가장 작은 값 도출
			result[0][0] = cave[0][0];

			while (true) {
				Node node = queue.poll();
				int i = node.index / n;
				int j = node.index % n;

				if (visited[i][j]) {
					continue;
				}

				result[i][j] = node.value;

				if (i == n - 1 && j == n - 1) {
					System.out.println("Problem " + cnt + ": " + result[i][j]);
					break;
				}

				visited[i][j] = true;

				if (i > 0) { // 상 이동
					int newIndex = (i - 1) * n + j;
					queue.offer(new Node(newIndex, cave[i - 1][j] + result[i][j]));
				}
				if (i < n - 1) { // 하 이동
					int newIndex = (i + 1) * n + j;
					queue.offer(new Node(newIndex, cave[i + 1][j] + result[i][j]));
				}
				if (j > 0) { // 좌 이동
					int newIndex = i * n + j - 1;
					queue.offer(new Node(newIndex, cave[i][j - 1] + result[i][j]));
				}
				if (j < n - 1) { // 우 이동
					int newIndex = i * n + j + 1;
					queue.offer(new Node(newIndex, cave[i][j + 1] + result[i][j]));
				}

			}
			cnt++;
		}

	}
}
