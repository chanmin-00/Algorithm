import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int N = Integer.parseInt(reader.readLine()); // 도시의 개수
		long[] kmArr = new long[N - 1];
		long[] literArr = new long[N];

		input = reader.readLine().split(" ");
		for (int i = 0; i < N - 1; i++) {
			kmArr[i] = Long.parseLong(input[i]);
		}

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			literArr[i] = Long.parseLong(input[i]);
		}

		long cost = 0;

		for (int i = N - 1; i > 0; i--) {
			long km = kmArr[i - 1];
			long min = Long.MAX_VALUE;

			for (int j = i - 1; j > -1; j--) {
				if (min > literArr[j]) {
					min = literArr[j];
				}
			}

			cost += (km * min);
		}

		System.out.println(cost);
	}
}
