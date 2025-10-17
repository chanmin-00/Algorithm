import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 각각의 파닭에 같은 양의 파를 넣는다.
// 될 수 있는 파의 양을 최대한 많이
// 하나의 파닭에는 하나 이상의 파가 들어가면 안된다.

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		Integer S = Integer.parseInt(input[0]); // 파의 개수
		long C = Long.parseLong(input[1]); // 파닭의 수

		long[] arr = new long[S]; // 파의 길이 배열
		long sum = 0;

		for (int i = 0; i < S; i++) {
			arr[i] = Long.parseLong(reader.readLine());
			sum += arr[i];
		}

		Arrays.sort(arr); // 오름차순 정렬

		long left = 1;
		long right = arr[S - 1];
		long mid = (left + right) / 2;
		long max = 0;


		while (left <= right) {
			// System.out.println("left " + left);
			// System.out.println("right " + right);

			long cnt = 0;

			for (int i = 0; i < S; i++) {
				cnt += arr[i] / mid;
			}

			if (cnt >= C) {
				max = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}

			mid = (left + right) / 2;
		}


		mid = max;

		sum -= max * C;
		
		System.out.println(sum);

	}
}
