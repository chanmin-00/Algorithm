import java.io.*;
import java.util.*;

public class Main {

	// 구하고자 하는  것
	// N번째 때 제일 작은 것과 큰  구해서 차이 구하기
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int N = Integer.parseInt(reader.readLine()); // 배열에 추가하려고 하는 정수 N
		int[] arr = new int[N + 1];

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i + 1] = Integer.parseInt(input[i]);
		}

		int[] min = new int[N + 1];
		int[] max = new int[N + 1];
		int[] result = new int[N + 1];

		result[1] = 0;
		min[1] = arr[1];
		max[1] = arr[1];
		System.out.print(result[1] + " ");

		for (int i = 2; i <= N; i++) {
			if (min[i - 1] > arr[i]) {
				min[i] = arr[i];
			} else {
				min[i] = min[i - 1];
			}

			if (arr[i] - min[i - 1] > result[i - 1]) {
				result[i] = arr[i] - min[i - 1];
			} else {
				result[i] = result[i - 1];
			}

			System.out.print(result[i] + " ");
		}

	}
}
