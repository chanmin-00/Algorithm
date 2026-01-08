import java.io.*;
import java.util.*;

// 벌들이 딸 수 있는 꿀의 최대 값을 계산
// 벌들이 있는 장소 2개, 벌통이 있는 장소 1개
// 벌들이 있는 장소는 합에 포함이 될 수 없다!!!
// 벌통의 장소가 정해지면
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static int N;
	static int[] arr;
	static long[] sum;
	static long answer = 0L;

	// 1. 벌통이 중간에 있는 경우 -> 무조건 벌은 양 끝에 위치해야 한다.
	// 2. 벌통이 왼쪽 끝에 있는 경우 -> 하나의 벌은 한쪽 끝에 무조건 있어야 한다. 중간 벌의 위치만 특정 지으면 됨

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(reader.readLine());
		arr = new int[N];
		sum = new long[N];

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);

			// 누적 합 계산
			if (i > 0) {
				sum[i] = sum[i - 1] + (long)arr[i];
			} else {
				sum[i] = (long)arr[i];
			}
		}

		// 1. 벌통이 중간에 있는 경우, 벌통의 위치를 옮겨가면서 파악
		for (int i = 1; i < N - 1; i++) {
			long tmp = 0;

			// 1.1. 인덱스 1부터 벌통의 위치까지 합
			tmp += (sum[i] - sum[0]);

			// 1.2. 벌통의 위치부터 인덱스 N-2까지의 합
			tmp += (sum[N - 2] - sum[i - 1]);

			answer = Math.max(answer, tmp);
		}

		// 2. 벌통이 오른쪽 끝에 있는 경우, 중간 벌의 위치를 옮겨가면서 파악
		for (int i = 1; i < N - 1; i++) {
			long tmp = 0;

			// 2.1 인덱스 1부터 벌통의 위치까지 합, 중간 벌의 값은 빼줘야 함
			tmp += (sum[N - 1] - sum[0]) - (long)arr[i];

			// 2.2 인덱스 i + 1부터 벌통의 위치까지 합
			tmp += (sum[N - 1] - sum[i]);

			answer = Math.max(answer, tmp);
		}

		// 3. 벌통이 왼쪽 끝에 있는 경우, 중간 벌의 위치를 옮겨가면서 파악
		for (int i = 1; i < N - 1; i++) {
			long tmp = 0;

			// 2.1 벌통 인덱스 0부터 오른쪽 끝 벌의 위치까지 합, 중간 벌의 값은 빼줘야 함
			tmp += sum[N - 2] - (long) arr[i];

			// 2.2 벌통 인덱스 0부터 중간 벌의 위치까지 합
			tmp += (sum[i - 1]);

			answer = Math.max(answer, tmp);
		}

		System.out.println(answer);

	}
}
