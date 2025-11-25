import java.io.*;
import java.util.*;

// 트리에 존재하는 모든 경로들 중에서 가장 긴 경로를 구하기
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static int n;
	static List<List<Neighborhood>> tree = new ArrayList<>();
	static boolean[] vistied;

	static int max = 0;

	static class Neighborhood {
		int v;
		int value;

		public Neighborhood(int v, int value) {
			this.v = v;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {

		n = Integer.parseInt(reader.readLine());
		vistied = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			input = reader.readLine().split(" ");

			int parent = Integer.parseInt(input[0]);
			int child = Integer.parseInt(input[1]);
			int value = Integer.parseInt(input[2]);

			tree.get(parent).add(new Neighborhood(child, value));
			tree.get(child).add(new Neighborhood(parent, value));
		}

		for (int i = 1; i <= n; i++) {
			vistied[i] = true;
			dfs(i, 0);
			vistied[i] = false;
		}

		System.out.println(max);
	}

	public static void dfs(int v, int currentValue) {
		List<Neighborhood> list = tree.get(v);

		// System.out.println("v : " + v + " currentValue : " + currentValue);

		for (int i = 0; i < list.size(); i++) {
			int nextV = list.get(i).v;
			int value = list.get(i).value;

			if (vistied[nextV] == false) {
				max = Math.max(max, currentValue + value);
				vistied[nextV] = true;

				dfs(nextV, currentValue + value);

				vistied[nextV] = false;
			}

		}
	}
}
