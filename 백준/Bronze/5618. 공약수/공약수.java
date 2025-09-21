import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];

		input = reader.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr);

		for (int i = 1; i <= arr[n - 1]; i++) {
			boolean flag = false;
			for (int j = 0; j < n; j++) {
				if (arr[j] % i != 0) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				System.out.println(i);
			}
		}

	}
}
