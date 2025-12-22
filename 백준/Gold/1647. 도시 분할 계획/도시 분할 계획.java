import java.io.*;
import java.util.*;

// N개의 집, 연결하는 M개의 길
// 길은 양방
// 모든 경로가 연결되어 있다 -> 이것은 트리를 의미한다.
// 최소 신장 트리가 될려면 길의 경로가 최소이면서 사이클이 생기면 안된다.
// 사이클이 생기지 않게 하기 위해서는 같은 그룹에 들어가 있으면 안된다.
// 같은 그룹지를 확인하기 위해서 find-union을 사용할 수 있다.
// find를 통해서 현재 그룹의 root 정점을 찾는다.
// root가 같다면 현재 같은 그룹에 속하는 것이다.
// root가 다르다면 다른 그룹, 사이클을 형성하지 않는다.
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static int N;
	static int M;
	static int[] arr;

	public static class Node {
		int A;
		int B;
		int C;

		public Node(int v1, int v2, int C) {
			if (v1 <= v2) {
				this.A = v1;
				this.B = v2;
			} else {
				this.A = v2;
				this.B = v1;
			}

			this.C = C;
		}
	}

	public static int find(int v) {
		while (arr[v] != v) {
			v = arr[v];
		}

		return arr[v];
	}

	public static void union(int v1, int v2) {
		int root1 = find(v1);
		int root2 = find(v2);

		if (root1 <= root2) {
			arr[root2] = root1;
		} else {
			arr[root1] = root2;
		}
	}

	public static void main(String[] args) throws IOException {
		int answer = 0;

		input = reader.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> {
			return n1.C - n2.C;
		});

		for (int i = 0; i < M; i++) {
			input = reader.readLine().split(" ");

			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);

			queue.offer(new Node(A, B, C));
		}

		int edge = 0; // 지금까지 트리의 간선의 수
		arr = new int[N + 1]; // 현재 정점의 그룹 정보를 담고 있음
		for (int i = 0; i <= N; i++) {
			arr[i] = i;
		}

		while (!queue.isEmpty()) {
			if (edge == N - 2) {
				break;
			}

			Node node = queue.poll();

			if (find(node.A) != find(node.B)) {
				union(node.A, node.B);
				// System.out.println("A : " + node.A + " B: " + node.B);
				answer += node.C;
				edge++;
			}
		}

		System.out.println(answer);
	}
}
