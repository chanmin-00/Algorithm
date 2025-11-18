import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static int N;
	static Set<Integer>[] setArr = new HashSet[3];
	static int[] P;
	static int[] S;

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(reader.readLine()); // 카드의 개수, 3 <= N <= 48, 3의 배수
		P = new int[N]; // 각 카드가 어떤 플레이어에 가야 하는지에 대한 정보

		// 카드를 섞는 방법에 대한 정보
		// i번째 위치한 카드는 S[i]번째 위치로 이동하여야 한다.
		S = new int[N];

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(input[i]);
		}

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(input[i]);
		}

		int cnt = 0; // 현재까지 섞은 횟수
		int[] old = new int[N];
		int[] tmp = new int[N];

		for (int i = 0; i < N; ++i) {
			old[i] = S[i];
		}

		for (int i = 0; i < 3; i++) {
			setArr[i] = new HashSet<>();
		}

		while (true) {
			for (int i = 0; i < N; ++i) {
				tmp[i] = old[i];
				//System.out.print(tmp[i] + " ");
			}
			// System.out.println();

			for (int i = 0; i < 3; i++) {
				setArr[i].clear();
			}

			for (int i = 0; i < N; i++) {
				if (i % 3 == 0) {
					setArr[0].add(old[i]);
				} else if (i % 3 == 1) {
					setArr[1].add(old[i]);
				} else {
					setArr[2].add(old[i]);
				}
			}

			boolean result = isCorrect();
			if (!result) {
				cnt++;
				//if (cnt == 3) {
				//	break;
				//}
			} else {
				break;
			}

			for (int i = 0; i < N; i++) {
				old[S[i]] = tmp[i];
			}

			if (Arrays.equals(S, old)){
				System.out.println(-1);
				return;
			}

		}

		System.out.println(cnt);

	}

	public static boolean isCorrect() {
		boolean flag = true;

		for (int i = 0; i < N; i++) {
			if (!setArr[P[i]].contains(S[i])) {
				flag = false;
				break;
			}
		}

		return flag;
	}

}

// 이것들은 카드 번호
// 1 2 0
// 0 1 2
// 2 0 1

// P[i]
// 2 0 1