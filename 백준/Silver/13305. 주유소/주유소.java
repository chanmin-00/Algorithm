import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int N = Integer.parseInt(reader.readLine()); // 도시의 개수
		int[] kmArr = new int[N - 1];
		int[] literArr = new int[N];

		input = reader.readLine().split(" ");
		for (int i = 0; i < N - 1; i++) {
			kmArr[i] = Integer.parseInt(input[i]);
		}

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			literArr[i] = Integer.parseInt(input[i]);
		}

		int cost = 0;

		for (int i = N - 1; i > 0; i--) {
			int km = kmArr[i - 1];
			int min = Integer.MAX_VALUE;

			for (int j = i - 1; j > -1; j--) {
				if (min > literArr[j]) {
					min = literArr[j];
				}
			}

			cost += km * min;
		}

		System.out.println(cost);
	}
}
