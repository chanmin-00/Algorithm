import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int N = Integer.parseInt(reader.readLine()); // 악보의 개수
		int[] arr = new int[N];

		// i번 인덱스에는 i번까지 몇 번 실수를 하는지 정보를 담고 있음.
		int[] mistake = new int[N];

		input = reader.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
			mistake[i] = 0;
		}

		for (int i = 0; i < N - 1; i++) {
			if (arr[i] > arr[i + 1]) { // 난이도가 높다면 실수를 함
				if (i == 0) { // 제일 첫 번째 악보인 경우
					mistake[i]++;
				} else {
					mistake[i] = mistake[i - 1] + 1;
				}
			} else {
				if (i != 0) {
					mistake[i] = mistake[i - 1];
				}
			}
		}

		if (N > 1) {
			mistake[N - 1] = mistake[N - 2];
		}

		int Q = Integer.parseInt(reader.readLine()); // 질문의 개수

		/**
		 for (int i = 0; i < N; i++) {
		 System.out.println("mistake " + i + ": " + mistake[i]);
		 }
		 **/

		for (int i = 0; i < Q; i++) {
			input = reader.readLine().split(" ");
			int x = Integer.parseInt(input[0]) - 1;
			int y = Integer.parseInt(input[1]) - 1;

			if (x > 0) {
				System.out.println(mistake[y - 1] - mistake[x - 1]);
			} else {
				if (y > 0) {
					System.out.println(mistake[y - 1]);
				}
				else {
					System.out.println(0);
				}

			}
		}
	}
}
