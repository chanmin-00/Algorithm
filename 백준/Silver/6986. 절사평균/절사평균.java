import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;
	static int N;
	static int K;
	static double[] arr;

	static double result1 = 0;
	static int cnt1 = 0;
	static double result2 = 0;
	static int cnt2 = 0;

	static double sum = 0;

	public static void main(String[] args) throws IOException {

		input = reader.readLine().split(" ");
		N = Integer.parseInt(input[0]); // 점수 개수
		K = Integer.parseInt(input[1]); // 제외하는 점수 개수

		arr = new double[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(reader.readLine());

		}

		Arrays.sort(arr); // 오름차순

		// 1. 절사평균 구하기
		double[] tmp1 = arr.clone();
		cnt1 = N - (K * 2);

		for (int i = 0; i < K; i++) {
			tmp1[i] = 0;
		}
		for (int i = N - 1; i > N - K - 1; i--) {
			tmp1[i] = 0;
		}

		for (int i = 0; i < N; i++) {
			sum += tmp1[i];
		}

		result1 = sum / cnt1;

		// 2. 보정평규 구하기
		sum = 0;
		double[] tmp2 = arr.clone();
		cnt2 = N;

		for (int i = 0; i < K; i++) {
			tmp2[i] = tmp2[K];
		}
		for (int i = N - 1; i > N - K - 1; i--) {
			tmp2[i] = tmp2[N - K - 1];
		}

		for (int i = 0; i < N; i++) {
			sum += tmp2[i];
		}

		result2 = sum / cnt2;

		System.out.println(String.format("%.2f", result1));
		System.out.println(String.format("%.2f", result2));
	}
}
