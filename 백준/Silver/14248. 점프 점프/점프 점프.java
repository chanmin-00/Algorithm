import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		n = Integer.parseInt(reader.readLine()); // 돌다리의 개수
		int s; // 출발점 s
		int cnt =0;
		arr = new int[n + 1];
		visited = new boolean[n + 1];

		input = reader.readLine().split(" ");

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(input[i - 1]);
		}

		s = Integer.parseInt(reader.readLine());
		visited[s] = true;

		dfs(s);

		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	public static void dfs(int index) {
		if (index + arr[index] <= n && !visited[index + arr[index]]) {
			visited[index + arr[index]] = true;
			dfs(index + arr[index]);
		}
		if (index - arr[index] >= 1 && !visited[index - arr[index]]) {
			visited[index - arr[index]] = true;
			dfs(index - arr[index]);
		}
	}
}
