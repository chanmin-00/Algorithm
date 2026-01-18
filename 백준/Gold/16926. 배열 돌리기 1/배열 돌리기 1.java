import java.io.*;
import java.util.*;

// R번 회전시킨다.
// 근데
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static int N;
	static int M;
	static int R;

	static int firstN;
	static int firstM;
	static int[][] arr;

	static int x = 0;
	static int y = 0;

	public static void main(String[] args) throws IOException {

		input = reader.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);

		firstN = N;
		firstM = M;

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			input = reader.readLine().split(" ");

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}

		while (N != 0 && M != 0) {
			int distance = N + N + M + M - 4; // 처음으로 돌아가기 위해 회전해야 하는 수

			// R번만큼 회전한 만큼의 결과를 얻기 위해서 실제로 회전하면 되는 수
			int rotation = R % distance;

			for (int i = 0; i < rotation; i++) {

				int tmpX = x;
				int tmpY = y;
				int prevValue = arr[tmpX][tmpY]; // 이전 값

				// 1. 아래쪽으로 내려가기
				for (int j = 0; j < N - 1; j++) {
					int tmp = arr[tmpX + 1][tmpY];
					arr[tmpX + 1][tmpY] = prevValue;
					prevValue = tmp;

					tmpX++;
				}

				// 2. 오른쪽으로 이동하기
				for (int j = 0; j < M - 1; j++) {
					int tmp = arr[tmpX][tmpY + 1];
					arr[tmpX][tmpY + 1] = prevValue;
					prevValue = tmp;

					tmpY++;
				}

				// 3. 위쪽으로 이동하기
				for (int j = 0; j < N - 1; j++) {
					int tmp = arr[tmpX - 1][tmpY];
					arr[tmpX - 1][tmpY] = prevValue;
					prevValue = tmp;

					tmpX--;
				}

				// 4. 왼쪽으로 이동하기
				for (int j = 0; j < M - 1; j++) {
					int tmp = arr[tmpX][tmpY - 1];
					arr[tmpX][tmpY - 1] = prevValue;
					prevValue = tmp;

					tmpY--;
				}
			}

			x++;
			y++;
			N = N - 2;
			M = M - 2;
		}

		for (int i = 0; i < firstN; i++) {
			for (int j = 0; j < firstM; j++) {
				System.out.print(arr[i][j] + " ");
			}

			System.out.println();
		}

	}
}
