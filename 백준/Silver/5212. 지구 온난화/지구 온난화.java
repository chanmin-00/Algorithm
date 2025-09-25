import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);

		char[][] old = new char[R][C];
		char[][] tmp = new char[R][C];

		int minR = 11;
		int maxR = -1;
		int minC = 11;
		int maxC = -1;

		for (int i = 0; i < R; i++) {
			String str = reader.readLine();

			for (int j = 0; j < C; j++) {
				old[i][j] = str.charAt(j);
			}
		}

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int cnt = 0;

				for (int k = 0; k < 4; k++) {

					if (old[i][j] == 'X') {
						int newI = i + dx[k];
						int newJ = j + dy[k];

						if ((newI >= 0 && newI < R) && (newJ >= 0 && newJ < C)) {

							if (old[newI][newJ] == '.') {
								cnt = cnt + 1;
							}
						}
						else {
							cnt = cnt + 1;
						}
					}
				}

				if (cnt >= 3) {
					tmp[i][j] = '.';
				}
				else {
					tmp[i][j] = old[i][j];
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (tmp[i][j] == 'X') {
					if (i < minR) {
						minR = i;
					}
					if (i > maxR) {
						maxR = i;
					}
					if (j < minC) {
						minC = j;
					}
					if (j > maxC) {
						maxC = j;
					}
				}
			}
		}

		char[][] newArr = new char[maxR - minR + 1][maxC - minC + 1];

		for (int i = 0; i < maxR - minR + 1; i++) {
			for (int j = 0; j < maxC - minC + 1; j++) {
				newArr[i][j] = tmp[i + minR][j+ minC];
				System.out.print(newArr[i][j]);
			}
			System.out.println();
		}

	}
}
