import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		char[][] arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = ' ';
			}
		}

		printStar(arr, 0, 0, n);

		StringBuilder result = new StringBuilder();
		for (int i=0;i<n;i++){
			result.append(arr[i]).append('\n');
		}

		System.out.println(result);

	}

	public static void printStar(char[][] arr, int x, int y, int size) {
		if (size == 1) {
			arr[x][y] = '*';
			return;
		}

		// 9등분씩 분할 정복을 해나간다.
		int newSize = size / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					continue;
				} else {
					printStar(arr, x + i * newSize, y + j * newSize, newSize);
				}
			}
		}

	}
}
