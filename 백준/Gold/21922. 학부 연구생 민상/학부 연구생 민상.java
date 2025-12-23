import java.io.*;
import java.util.*;

// 구하고자 하는 것 : 바람이 지나가는 길의 개수
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static int N; // 연구실의 크기 세로
	static int M; // 연구실의 크기 가로
	static int startI = 0;
	static int startJ = 0;

	static int[][] arr;
	static boolean[][] aircon;

	// 1번 : 북, 2번 : 동, 3번 : 남, 4번 : 서
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		input = reader.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		arr = new int[N + 1][M + 1];
		aircon = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			input = reader.readLine().split(" ");

			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		// 북 -> 동 -> 남 -> 서
		// i == 0 : 북
		// 북(0) + 2 : 멈춤
		// 북(0) + 3 : 동 (1)
		// 북(0) + 4 : 서 (3)
		// 동(1) + 1 : 멈춤
		// 동(1) + 3 : 북 (0)
		// 동(1) + 4 : 남 (2)

		for (int nineI = 1; nineI <= N; nineI++) {
			startI = 0;
			startJ = 0;

			for (int nineJ = 1; nineJ <= M; nineJ++) {
				if (arr[nineI][nineJ] == 9) {
					startI = nineI;
					startJ = nineJ;
					aircon[startI][startJ] = true;

					for (int i = 0; i < 4; i++) {
						int currI = startI + dx[i];
						int currJ = startJ + dy[i];
						int nowDirect = i;

						while (true) {
							if (currI < 1 || currI > N || currJ < 1 || currJ > M) {
								break;
							}

							aircon[currI][currJ] = true;

							if (nowDirect == 0) { // 북쪽 방향
								if (arr[currI][currJ] == 2) { // 멈춤
									break;
								} else if (arr[currI][currJ] == 3) { // 동쪽 방향으로 변경
									nowDirect = 1;
									currI = currI + dx[nowDirect];
									currJ = currJ + dy[nowDirect];
								} else if (arr[currI][currJ] == 4) { // 서쪽 방향으로 변경
									nowDirect = 3;
									currI = currI + dx[nowDirect];
									currJ = currJ + dy[nowDirect];
								} else { // 해당 방향으로 진행
									currI = currI + dx[nowDirect];
									currJ = currJ + dy[nowDirect];
								}
							} else if (nowDirect == 1) { // 동쪽
								if (arr[currI][currJ] == 1) { // 멈춤
									break;
								} else if (arr[currI][currJ] == 3) { // 북쪽 방향으로 변경
									nowDirect = 0;
									currI = currI + dx[nowDirect];
									currJ = currJ + dy[nowDirect];
								} else if (arr[currI][currJ] == 4) { // 남쪽 방향으로 변경
									nowDirect = 2;
									currI = currI + dx[nowDirect];
									currJ = currJ + dy[nowDirect];
								} else { // 해당 방향으로 진행
									currI = currI + dx[nowDirect];
									currJ = currJ + dy[nowDirect];
								}
							} else if (nowDirect == 2) { // 남쪽
								if (arr[currI][currJ] == 2) { // 멈춤
									break;
								} else if (arr[currI][currJ] == 3) { // 서쪽 방향으로 변경
									nowDirect = 3;
									currI = currI + dx[nowDirect];
									currJ = currJ + dy[nowDirect];
								} else if (arr[currI][currJ] == 4) { // 동쪽 방향으로 변경
									nowDirect = 1;
									currI = currI + dx[nowDirect];
									currJ = currJ + dy[nowDirect];
								} else { // 해당 방향으로 진행
									currI = currI + dx[nowDirect];
									currJ = currJ + dy[nowDirect];
								}
							} else if (nowDirect == 3) { // 서쪽
								if (arr[currI][currJ] == 1) { // 멈춤
									break;
								} else if (arr[currI][currJ] == 3) { // 남쪽 방향으로 변경
									nowDirect = 2;
									currI = currI + dx[nowDirect];
									currJ = currJ + dy[nowDirect];
								} else if (arr[currI][currJ] == 4) { // 북쪽 방향으로 변경
									nowDirect = 0;
									currI = currI + dx[nowDirect];
									currJ = currJ + dy[nowDirect];
								} else { // 해당 방향으로 진행
									currI = currI + dx[nowDirect];
									currJ = currJ + dy[nowDirect];
								}
							}
						}
					}
				}
			}
		}


		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (aircon[i][j] == true) {
					// System.out.println("i " + i + " j " + j);
					result++;
				}
			}
		}

		System.out.println(result);
	}
}
