import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 사람들의 키는 1부터 N까지 모두 다 다르다.
	// 키가 1인 사람부터 차례대로 자기보다 키 큰 사람이 왼쪽에 몇 명이 있는지 주어진다.
	// 키가 작은 순서대로 위치를 먼저 정해야 하는건가
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine()); // n명의 사람들
		int[] arr = new int[n + 1]; // 왼쪽에 키 큰 사람이 몇 명이 저장이 되어 있는지 정보 저장

		int[] result = new int[n + 1]; // 결과 정보를 저장할 배열
		for (int i = 0; i <= n; i++) {
			result[i] = Integer.MAX_VALUE;
		}

		String[] input = reader.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i + 1] = Integer.parseInt(input[i]);
		}

		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			int index = 1;
			while (cnt < arr[i]) {
				if (i < result[index]) {
					cnt++;
				}
				index++;
			}

			while (result[index] != Integer.MAX_VALUE && index <= n) {
				index++;
			}
			result[index] = i;
			// System.out.println("index : " + index + " value: " + i);
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			stringBuilder.append(result[i]).append(" ");
		}
		System.out.println(stringBuilder);
	}
}
