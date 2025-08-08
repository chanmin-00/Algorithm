import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = reader.readLine().split(" ");

		int r = Integer.parseInt(input[0]); // r행
		int c = Integer.parseInt(input[1]); // c열
		int t = Integer.parseInt(input[2]); // t초 경과

		int[][][] arr = new int[2][r + 1][c + 1];

		int upAir = 0; // 공기청정기 첫 번째 행
		int downAir = 0; // 공기청정기 두번째 행

		int prev = 0;
		int next = 1;

		for (int i = 1; i <= r; i++) {
			input = reader.readLine().split(" ");
			for (int j = 1; j <= c; j++) {
				arr[prev][i][j] = Integer.parseInt(input[j - 1]);
				arr[next][i][j] = arr[prev][i][j];

				if (arr[prev][i][j] == -1 && upAir == 0) {
					upAir = i;
				} else if (arr[prev][i][j] == -1 && upAir != 0) {
					downAir = i;
				}
			}
		}

		for (int i = 0; i < t; i++) {
			int upX;
			int downX;
			int leftY;
			int rightY;
			int value;

			// 확산, 덮어씌어질 수 있음을 주의해야 한다.
			for (int j = 1; j <= r; j++) {
				for (int k = 1; k <= c; k++) {
					upX = j - 1;
					downX = j + 1;
					leftY = k - 1;
					rightY = k + 1;

					value = arr[prev][j][k] / 5;
					int cnt = 0;

					if (upX > 0 && arr[prev][upX][k] != -1) {
						arr[next][upX][k] += value;
						cnt++;
					}
					if (downX <= r && arr[prev][downX][k] != -1) {
						arr[next][downX][k] += value;
						cnt++;
					}
					if (leftY > 0 && arr[prev][j][leftY] != -1) {
						arr[next][j][leftY] += value;
						cnt++;
					}
					if (rightY <= c && arr[prev][j][rightY] != -1) {
						arr[next][j][rightY] += value;
						cnt++;
					}

					arr[next][j][k] -= value * cnt;
				}
			}
			

			// 공기청정기 위쪽부터
			for (int j = upAir - 2; j >= 1; j--) {
				arr[next][j + 1][1] = arr[next][j][1];
			}
			for (int j = 2; j <= c; j++) {
				arr[next][1][j - 1] = arr[next][1][j];
			}
			for (int j = 2; j <= upAir; j++) {
				arr[next][j - 1][c] = arr[next][j][c];
			}
			for (int j = c - 1; j >= 2; j--) {
				arr[next][upAir][j + 1] = arr[next][upAir][j];
			}

			arr[next][upAir][2] = 0; // 새로운 공기 진입

			// 공기청정기 아래쪽부터
			for (int j = downAir + 2; j <= r; j++) {
				arr[next][j - 1][1] = arr[next][j][1];
			}
			for (int j = 2; j <= c; j++) {
				arr[next][r][j - 1] = arr[next][r][j];
			}
			for (int j = r; j >= downAir + 1; j--) {
				arr[next][j][c] = arr[next][j - 1][c];
			}
			for (int j = c; j > 2; j--) {
				arr[next][downAir][j] = arr[next][downAir][j - 1];
			}

			arr[next][downAir][2] = 0; // 새로운 공기 주입
			
			for (int j = 1; j <= r; j++) { // prev로 원상 복구
				for (int k = 1; k <= c; k++) {
					arr[prev][j][k] = arr[next][j][k];
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (arr[prev][i][j] != -1) {
					sum += arr[prev][i][j];
				}
			}
		}

		System.out.println(sum);
	}
}
