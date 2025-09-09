import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int n = Integer.parseInt(reader.readLine()); // 스위치의 개수
		int student;
		int[] arr = new int[n + 1];

		input = reader.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(input[i - 1]);
		}

		student = Integer.parseInt(reader.readLine());

		for (int i = 0; i < student; i++) {
			input = reader.readLine().split(" ");
			int num = Integer.parseInt(input[1]); // 받은 수
			int tmp = num;
			int left = num - 1;
			int right = num + 1;

			if (Integer.parseInt(input[0]) == 1) { // 남자인 경우
				int cnt = 2;

				while (tmp <= n) {
					if (arr[tmp] == 1) {
						arr[tmp] = 0;
					} else {
						arr[tmp] = 1;
					}
					tmp = num * cnt;
					cnt++;
				}
			} else { // 여자인 경우
				if (arr[num] == 1) {
					arr[num] = 0;
				} else {
					arr[num] = 1;
				}

				while (left >= 1 && right <= n) {
					if (arr[left] == arr[right]) {
						if (arr[left] == 1) {
							arr[left] = 0;
						} else {
							arr[left] = 1;
						}

						if (arr[right] == 1) {
							arr[right] = 0;
						} else {
							arr[right] = 1;
						}
						left--;
						right++;
					} else {
						break;
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}
}
