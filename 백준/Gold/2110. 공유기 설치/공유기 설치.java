import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] arr;

	// 가장 인접한 두 공유기 사이의 거리를 가능한 최대로
	// 최소 거리가 5라고 하면, 모든 공유기 사이의 거리가 5이상이어야 한다.
	// 최소 거리를 특정 했을 때 그게 가능해야 한다.
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int N = Integer.parseInt(input[0]); // 집의 개수
		int C = Integer.parseInt(input[1]); // 공유기의 개수

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}

		Arrays.sort(arr);

		int leftIndex = 1; // 최소 간격 하한
		int rightIndex = arr[N - 1] - arr[0]; // 최소 간격 상한
		int mid = 0; // 공유기 간의 최소 거리
		int result = 0;

		while (leftIndex <= rightIndex) {
			mid = (leftIndex + rightIndex) / 2;

			// System.out.println("leftInde : " + leftIndex);
			// System.out.println("rightIndex " + rightIndex);
			// System.out.println("mid : " + mid);

			if (!checking(mid, N, C)) { // 가능하지 않은 최소 거리인 경우
				rightIndex = mid - 1; // 가능하지 않은 경우는 크기를 더 줄여봐야 함. mid가 되지 않았으므로, leftIndex ~ mid - 1 사이여야 함
			} else {
				result = mid;
				leftIndex = mid + 1; // 가능한 경우는 크기를 더 늘려서 도전을 해봐야 함
			}
		}

		System.out.println(result);
	}

	public static boolean checking(int distance, int N, int C) {
		int nowIndex = 0;
		int cnt = 0;

		for (int i = 1; i < N; i++) {
			if (arr[nowIndex] + distance <= arr[i]) {
				nowIndex = i;
				cnt++;
			}
		}

		if (cnt + 1 >= C) {
			return true;
		} else {
			return false;
		}
	}
}
