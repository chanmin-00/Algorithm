import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = reader.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // 학생 수
		int m = Integer.parseInt(input[1]); // 친구 관계 수
		int k = Integer.parseInt(input[2]); // 가지고 있는 돈
		int[] friendMoney = new int[n + 1]; // 친구비 배
		int[] friendArr = new int[n + 1];
		int sum = 0;

		for (int i = 0; i <= n; i++) {
			friendArr[i] = i;
		}

		input = reader.readLine().split(" ");

		for (int i = 1; i <= n; i++) {
			friendMoney[i] = Integer.parseInt(input[i - 1]);
		}

		for (int i = 1; i <= m; i++) {
			input = reader.readLine().split(" ");
			int v = Integer.parseInt(input[0]);
			int w = Integer.parseInt(input[1]);

			int vRoot = find(v, friendArr);
			int wRoot = find(w, friendArr);

			if (vRoot < wRoot) {
				friendArr[wRoot] = vRoot;
			} else {
				friendArr[vRoot] = wRoot;
			}
		}

		List<PriorityQueue<Integer>> queueList = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			queueList.add(new PriorityQueue<>());
		}

		for (int i = 1; i <= n; i++) {
			int root = find(i, friendArr);

			queueList.get(root).offer(friendMoney[i]);
		}

		for (int i = 1; i <= n; i++) {

			if (!queueList.get(i).isEmpty()) {
				sum += queueList.get(i).poll();
			}
		}

		if (sum <= k) {
			System.out.println(sum);
		} else {
			System.out.println("Oh no");
		}

	}

	public static int find(int v, int[] findArr) {
		while (v != findArr[v]) {
			v = findArr[v];
		}

		return v;
	}
}
