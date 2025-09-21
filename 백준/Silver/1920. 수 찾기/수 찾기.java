import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int N = Integer.parseInt(reader.readLine());
		input = reader.readLine().split(" ");
		int[] arr = new int[N];

		Map<Integer, Integer> map = new HashMap();
		int index = 0;

		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(input[i]);

			if (!map.containsKey(value)) {
				arr[index] = value;
				index++;
				map.put(value, 0);
			}
		}

		int[] newArr = new int[index];

		for (int i = 0; i < index; i++) {
			newArr[i] = arr[i];
		}
		Arrays.sort(newArr);


		int M = Integer.parseInt(reader.readLine());
		input = reader.readLine().split(" ");
		int[] num = new int[M];

		for (int i = 0; i < M; i++) {
			num[i] = Integer.parseInt(input[i]);

			System.out.println(find(newArr, num[i], index));
		}
	}

	public static int find(int[] arr, int num, int size) {
		int left = 0;
		int right = size - 1;
		int mid = (left + right) / 2;

		while (left <= right) {
			if (arr[mid] == num) {
				return 1;
			} else if (arr[mid] > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

			mid = (left + right) / 2;
		}

		return 0;
	}
}
