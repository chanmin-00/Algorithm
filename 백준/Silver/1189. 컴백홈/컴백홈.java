import java.io.*;
import java.util.*;

public class Main {

	static String[] input;
	static String[][] arr;

	static int R;
	static int C;
	static int K;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	static boolean[][] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		input = reader.readLine().split(" ");

		R = Integer.parseInt(input[0]); // 행
		C = Integer.parseInt(input[1]); // 열
		K = Integer.parseInt(input[2]); // 가지수

		arr = new String[R][C];
		visited = new boolean[R][C];

		cnt = 0;

		for (int i = 0; i < R; i++) {
			String str = reader.readLine();

			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j) + "";
			}
		}

		visited[R - 1][0] = true;
		dfs(R - 1, 0, 1);


		System.out.println(cnt);

	}

	public static void dfs(int i, int j, int tmp) {

		// System.out.println("int i : " + i + " int j " + j + " tmp " + tmp + " K " + K);

		if (i == 0 && j == C - 1) {
			if (tmp == K) {
				cnt = cnt + 1;
			}

			return;
		}

		for (int k = 0; k < 4; k++) {
			int newI = i + dx[k];
			int newJ = j + dy[k];

			if (newI >= 0 && newI < R && newJ >= 0 && newJ < C && !arr[newI][newJ].equals("T")) {
				if (!visited[newI][newJ]) {

					visited[newI][newJ] = true;
					tmp = tmp + 1;
					dfs(newI, newJ, tmp);

					visited[newI][newJ] = false;
					tmp = tmp - 1;
				}
			}
		}
	}
}
