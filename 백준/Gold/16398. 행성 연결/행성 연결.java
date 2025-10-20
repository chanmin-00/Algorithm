import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	// 모두 연결 시켜야 함. 트리임
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());
		int[][] arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] input = reader.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		boolean[] visited = new boolean[N + 1];

		Set<Integer> visitedSet = new HashSet<>();

		visitedSet.add(1);
		visited[1] = true;

		long result = 0;

		while (visitedSet.size() != N) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;

			for (Integer key : visitedSet) {
				for (int i = 1; i <= N; i++) {
					if (key != i && !visited[i]) {
						if (min > arr[key][i]) {
							minIndex = i;
							min = arr[key][i];
						}
					}
				}
			}

			visited[minIndex] = true;
			visitedSet.add(minIndex);

			result += min;

		}

		System.out.println(result);
	}

}
