import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		long result = 0L;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}

		Arrays.sort(arr); // 오름차순 정렬, 하지만 내림차순으로 사용할 거임

		long grade = 0L;
		for (int i = n - 1; i >= 0; i--) {
			long tmp = (long) arr[i] - grade;
			if (tmp > 0) {
				result += (long) arr[i] - grade;
			}

			grade++;
		}

		System.out.println(result);
	}
}
