
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr;

		inputArr = reader.readLine().split(" ");

		int v = Integer.parseInt(inputArr[0]); // 마을의 개수
		int e = Integer.parseInt(inputArr[1]); // 도로의 개수
		int[][] arr = new int[v + 1][v + 1];
		int[][] distance = new int[v + 1][v + 1];

		for (int i = 0; i <= v; i++) {
			for (int j = 0; j <= v; j++) {
				distance[i][j] = -1; // 거리가 무한대
			}
		}

		for (int i = 1; i <= e; i++) {
			inputArr = reader.readLine().split(" ");

			int a = Integer.parseInt(inputArr[0]);
			int b = Integer.parseInt(inputArr[1]); // a->b
			int c = Integer.parseInt(inputArr[2]); // 거리 c

			arr[a][b] = c;
			distance[a][b] = c; // a->b로 가는 최단거리를 갱신해야 한다.
		}

		for (int k = 1; k <= v; k++) {
			for (int i = 1; i <= v; i++) {
				if (k != i) {
					for (int j = 1; j <= v; j++) {
						if (k != j) {
							if (distance[i][j] == -1 && distance[i][k] != -1 && distance[k][j] != -1) { // 무한대, 무한대 아님, 무한대 아님
								distance[i][j] = distance[i][k] + distance[k][j];
							} else if (distance[i][j] != -1 &&  distance[i][k] != -1 && distance[k][j] != -1) {
								distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
							}

						}
					}
				}
			}
		}

		int result = Integer.MAX_VALUE;
		boolean changed = false;
		for (int i = 1; i <= v; i++) {
			if (result > distance[i][i] && distance[i][i] > 0) {
				result = distance[i][i];
				changed = true;
			}
		}

		if (!changed) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}
}
