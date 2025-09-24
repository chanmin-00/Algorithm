import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	static List<Integer> list = new ArrayList<>();
	static boolean[][] visited;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(reader.readLine()); // 지도의 크기

		visited = new boolean[N + 1][N + 1];
		int[][] arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String input = reader.readLine();

			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(input.charAt(j - 1) + "");
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int result = search(0, i, j, arr);

				if (result != 0) {
					list.add(result);
				}
			}
		}

		Collections.sort(list);

		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static int search(int cnt, int r, int c, int[][] arr) {

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		if (visited[r][c] || arr[r][c] != 1) {
			return 0;
		}

		visited[r][c] = true;

		int result = 1;

		for (int i = 0; i < 4; i++) {
			int newX = r + dx[i];
			int newY = c + dy[i];

			if ((newX > 0 && newX <= N) && (newY > 0 && newY <= N)) {
				result += search(cnt + arr[newX][newY], newX, newY, arr);
			}
		}

		return result;
	}
}
