import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 최소 횟수로 하기 위해서는 가능한 한 2배를 많이 해야 한다.
	// 배열 B의 총합이 짝수란 말은 그 전에 2배를 해야 한다는 말
	// 배열 B의 총합이 홀수란 말은 그 전에 + 1을 했다는 말
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int N = Integer.parseInt(reader.readLine()); // 배열의 크기 N
		int[] bArr = new int[N]; // A가 되고 싶어하는 배열 B

		int cnt = 0;

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			bArr[i] = Integer.parseInt(input[i]);
		}

		boolean isZero = false;
		int oddCnt = 0;

		while (!isZero) {
			oddCnt = 0;

			for (int i = 0; i < N; i++) {
				if (bArr[i] % 2 == 1) { // 홀수가 등장하는 경우
					bArr[i] -= 1;
					cnt++;
					oddCnt++;
					break;
				}
			}

			isZero = true;

			if (oddCnt == 0) { // 짝수만 있는 경우
				for (int i = 0; i < N; i++) {
					if (bArr[i] > 0) {
						bArr[i] /= 2;
						isZero = false;
					}

				}

				if (!isZero) {
					cnt++;
				}
			}

			isZero = true;

			for (int i = 0; i < N; i++) {
				if (bArr[i] > 0) {
					isZero = false;
					break;
				}
			}

		}

		System.out.print(cnt);
	}
}
