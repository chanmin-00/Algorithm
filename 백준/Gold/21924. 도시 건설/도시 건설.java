import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int weight;

		Edge(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge other) {
			return this.weight - other.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = reader.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // 건물의 개수
		int m = Integer.parseInt(input[1]); // 도로의 개수
		long sum = 0; // 절약하지 않을 때의 모든 합
		long cost = 0; // 도로 건설 최소 비용의 합
		int cnt = 0; // 간선의 개수

		int[] group = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			group[i] = i;
		}

		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

		for (int i = 0; i < m; i++) {
			input = reader.readLine().split(" ");

			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);

			sum += c;

			priorityQueue.offer(new Edge(a, b, c));
		}

		while (!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll();

			int v1 = edge.v1;
			int v2 = edge.v2;

			int v1Group = find(v1, group);
			int v2Group = find(v2, group);

			if (v1Group != v2Group) {
				if (v1Group < v2Group) {
					group[v2Group] = v1Group;
				} else {
					group[v1Group] = v2Group;
				}

				cost += edge.weight;
				cnt++;
				if (cnt == n - 1) {
					break;
				}
			}

		}
		if (cnt == n - 1) {
			System.out.println(sum - cost);
		} else {
			System.out.println(-1);
		}

	}

	public static int find(int v, int[] group) {
		while (v != group[v]) {
			v= group[v];
		}

		return v;
	}
}
