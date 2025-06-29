
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int t;
	static int m;
	static int n;

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 표준 입력

		t = Integer.parseInt(reader.readLine()); // 테스트 케이스 개수

		for (int i = 0; i < t; i++) {
			String[] input = reader.readLine().split(" ");
			m = Integer.parseInt(input[0]); // 배추밭의 가로 길이
			n = Integer.parseInt(input[1]); // 배추밭의 세로 길이
			int k = Integer.parseInt(input[2]); // 배추 개수
			int[][] arr = new int[51][51]; // 자바 배열 선언, 숫자 타입의 배열은 기본적으로 0으로 초기화

			for (int j = 0; j < k; j++) {
				int num1, num2;
				String[] tmp = reader.readLine().split(" ");
				num1 = Integer.parseInt(tmp[0]);
				num2 = Integer.parseInt(tmp[1]);
				arr[num2][num1] = 1; // 가로/세로 주의
			}

			int val = getSnakeCount(arr);
			System.out.println(val);

		}

	}

	public static int getSnakeCount(int[][] arr) {
		int[][] visited = new int[51][51];
		int returnVal = 0;

		for (int y = 0; y < n; y++) { // 세로 탐색
			for (int x = 0; x < m; x++) { // 가로 탐색
				if (arr[y][x] == 1 && visited[y][x] == 0) { // 방문하지 않았고 배추가 있는 경우 탐색 시작
					dfs(arr, visited, x, y);
					returnVal++; // 배추가 1개는 무조건 있기 때문에 증가
				}
			}
		}
		return returnVal;
	}

	public static void dfs(int[][] arr, int[][] visited, int x, int y) {
		if (x < 0 || y < 0 || x >= m || y >= n) // 경계를 침범한 경우
			return;
		if (visited[y][x] == 1 || arr[y][x] == 0) // 방문했거나 배추가 없는 경우는 return
			return;

		visited[y][x] = 1;
		
		// 상하좌우 이동
		dfs(arr, visited, x - 1, y);
		dfs(arr, visited, x + 1, y);
		dfs(arr, visited, x, y - 1);
		dfs(arr, visited, x, y + 1);
	}
}
