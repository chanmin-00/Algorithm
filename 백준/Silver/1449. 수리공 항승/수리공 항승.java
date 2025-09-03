import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	// 테이프는 자를 수 없다.
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int N = Integer.parseInt(input[0]); // 물이 세는 곳의 개수
		int L = Integer.parseInt(input[1]); // 테이프의 길이
		int result = 0;
		double tape = 0; // 현재 테이프가 붙여진 가장 끝자리 위치

		int[] arr = new int[N];

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr); // 오름차순으로 정렬

		for (int i = 0; i < N; i++) {
			if (tape <= arr[i]) {
				tape = arr[i] - 0.5 + L;
				result++;
			}
		}

		System.out.print(result);

	}
}
