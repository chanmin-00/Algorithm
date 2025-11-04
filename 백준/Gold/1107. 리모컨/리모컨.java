import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

	// 지금 보고 있는 채널은 100
	// 일부 숫자 버튼만 고장남
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine()); // 이동하려고 하는 채널 N
		int M = Integer.parseInt(reader.readLine()); // 고장난 버튼의 개수
		HashSet<String> set = new HashSet<>();

		if (M != 0) {
			String[] input = reader.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				set.add(input[i]);
			}
		}

		int min = Integer.MAX_VALUE;
		int len = 0;

		for (int i = 0; i <= 999999; i++) {
			String num = i + "";

			boolean breakFlag = false;
			for (int j = 0; j < num.length(); j++) {
				if (set.contains(num.charAt(j) + "")) {
					breakFlag = true;
					break;
				}
			}

			if (breakFlag == false) {
				if (min > Math.abs(N - i)) {
					min = Math.abs(N - i);
					// System.out.println(min);
					len = num.length();
				} else {
					break;
				}
			}

			// System.out.println(num);

		}

		if (Math.abs(100 - N) < min + len) {
			System.out.println(Math.abs(100 - N));
		} else {
			System.out.println(min + len);
		}

	}
}
