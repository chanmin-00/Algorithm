import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine()); // 정점의 개수
		int[][] graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] input = reader.readLine().split(" ");

			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}

	}
}
