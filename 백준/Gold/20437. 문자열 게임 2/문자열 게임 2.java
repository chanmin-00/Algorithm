import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(reader.readLine());

		for (int i = 0; i < t; i++) {

			String wStr = reader.readLine(); // 알파벳 소문자로 이루어진 문자열 w
			int k = Integer.parseInt(reader.readLine()); // 양의 정수 k

			game(wStr, k);

		}
	}

	public static void game(String wStr, int k) {
		List<LinkedList<Integer>> arr = new ArrayList<>(26); // 공간 예약만 함. 초기화 필수
		for (int i = 0; i < 26; i++) {
			arr.add(new LinkedList<>());
		}

		boolean isChanged = false;

		int min = wStr.length();
		int max = -1;

		for (int i = 0; i < wStr.length(); i++) {
			int index = wStr.charAt(i) - 'a';

			LinkedList<Integer> alphabetList = arr.get(index);

			alphabetList.add(i);

			if (alphabetList.size() >= k) {
				isChanged = true;

				int index1 = alphabetList.get(alphabetList.size() - 1);
				int index2 = alphabetList.get(alphabetList.size() - k);

				int length = index1 - index2 + 1;

				if (length < min) {
					min = length;
				}

				if (length > max) {
					max = length;
				}
			}
		}

		if (isChanged) {
			System.out.println(min + " " + max);
		} else {
			System.out.println(-1);
		}

	}

}
