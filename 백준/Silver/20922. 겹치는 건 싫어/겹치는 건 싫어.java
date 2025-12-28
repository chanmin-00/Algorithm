import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static int N;
	static int K;
	static int[] arr;
	static int[] numArr = new int[200001];
	static int answer = 0; // 답
	static int left = 0;

	public static void main(String[] args) throws IOException {

		input = reader.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		arr = new int[N];

		input = reader.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		for (int i = 0; i < N; i++) {
			int num = arr[i];

			if ((numArr[num] + 1) > K) {

				for (int j = left; j < i; j++) {
					if (arr[j] == num) {
						numArr[num]--;
						left = j + 1;
						break;
					}
					else {
						numArr[arr[j]]--;
					}
				}

				if (i - left + 1 > answer) {
					answer = i - left + 1;
					// System.out.println(" I " + i + " left " + left);
				}

				numArr[num]++;
			} else {
				numArr[num]++;
				if (i - left + 1> answer) {
					answer = i - left + 1;
					// System.out.println(" I " + i + " left " + left);
				}
			}
		}

		System.out.println(answer);

	}
}
