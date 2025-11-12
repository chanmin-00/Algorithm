import java.util.*;
import java.io.*;

public class Main {

	static int max;
	static int[] arr;

	// 합이 50이 되는 것이 최대한 많이 되도록 해야 함
	// 합이 50이 되는 조합을 많이 찾아야 함
	// 개의 수의 합은 항상 100이다.
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine()); // 학교에서의 반의 개수, 1~8

		arr = new int[N];

		String[] input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr);

		permutation(new int[N], new boolean[N], 0, N);

		if (max > 0) {
			System.out.println(max - 1);
		} else {
			System.out.println(0);
		}

	}

	public static void permutation(int[] tmpArr, boolean[] visited, int depth, int N) {
		if (depth == N) {
			int lines = countLines(tmpArr);

			max = Math.max(max, lines);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {

				// 중복된 순서를 제거
				if (i > 0 && arr[i - 1] == arr[i] && !visited[i - 1]) {
					continue;
				}

				visited[i] = true;
				tmpArr[depth] = arr[i];
				permutation(tmpArr, visited, depth + 1, N);
				visited[i] = false;
			}
		}
	}

	public static int countLines(int[] tmpArr) {
		Set<Integer> boundary = new HashSet<>();
		boundary.add(0);

		int val = 0;
		for (int tmp : tmpArr) {
			val += tmp;
			boundary.add(val);
		}

		int count = 0;
		for (int b : boundary) {
			if (b < 100 & boundary.contains(b + 50)) {
				count++;
			}
		}

		return count;

	}
}
