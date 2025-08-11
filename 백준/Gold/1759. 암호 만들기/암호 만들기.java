import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	// 암호는 알파벳 소문자들로 구성
	// 최소 1개의 모음(a, e, i, o, u) + 최소 2개의 자음
	// 알파벳이 암호에서 정렬된 순서
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int L = Integer.parseInt(input[0]); // 문자열의 길이
		int C = Integer.parseInt(input[1]); // 암호로 사용했을 법한 문자의 수
		String[] arr = new String[C];

		input = reader.readLine().split(" ");
		for (int i = 0; i < C; i++) {
			arr[i] = input[i];
		}

		Arrays.sort(arr); // 백트래킹으로 찾아가기 위해 노드 정렬

		// cnt는 모음의 개수 판단
		backtrack(arr, new ArrayList<>(), 0, 0, 0, L);
	}

	static void backtrack(String[] arr, List<String> list, int gatherCnt, int
		consonantCnt, int index, int L) {
		if (list.size() == L && gatherCnt > 0 && consonantCnt > 1) {
			for (String s : list) {
				System.out.print(s);
			}
			System.out.println();
			return;
		}

		for (int i = index; i < arr.length; i++) {

			list.add(arr[i]);
			if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i")
				|| arr[i].equals("o") || arr[i].equals("u")) {
				gatherCnt++;
			} else {
				consonantCnt++;
			}

			backtrack(arr, list, gatherCnt, consonantCnt, i + 1, L);

			if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i")
				|| arr[i].equals("o") || arr[i].equals("u")) {
				gatherCnt--;
			} else {
				consonantCnt--;
			}

			list.remove(list.get(list.size() - 1));
		}
	}
}
