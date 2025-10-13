import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int N = Integer.parseInt(input[0]); // 블로그를 시작하고 지난 일수
		int X = Integer.parseInt(input[1]); // 기간

		int[] arr = new int[N];

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int value = 0;
		int max = 0;
		int cnt = 1; // 같은 기간 수
		for (int i = 0; i < X; i++) {
			value += arr[i];
		}
		max = value;

		for (int i = 1; i + X - 1 < N; i++) {
			value -= arr[i - 1];
			value += arr[i + X - 1];

			if (value > max) {
				max = value;
				cnt = 1;
			} else if (value == max) {
				cnt++;
			} else {

			}
		}

		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
