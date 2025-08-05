import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {

	static int len;
	static TreeSet<Integer> treeSet = new TreeSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine()); // 단어의 개수

		for (int i = 0; i < n; i++) {
			String oldStr = reader.readLine();
			len = oldStr.length();
			char[] charArr = new char[len];
			boolean[] used = new boolean[len];

			for (int j = 0; j < len; j++) {
				charArr[j] = oldStr.charAt(j);
			}

			Arrays.sort(charArr); // 사전순으로 출력하기 위해 사전순 정렬

			StringBuilder sb = new StringBuilder();
			backtrack(sb, charArr, used);

		}
	}

	public static void backtrack(StringBuilder sb, char[] charArr, boolean[] used) {
		if (sb.length() == len) {
			System.out.println(sb);
		} else {
			for (int i = 0; i < charArr.length; i++) { // for 문 안에서 반복되는 것은 같은 레벨
				if (used[i]) { // 이미 진행한 알파벳일 경우 건너띈다.
					continue;
				}

				if (i > 0 && charArr[i - 1] == charArr[i] && !used[i - 1]) { // 동일 레벨에서 중복 문자를 처리하지 않음, 같은 문자열이 나오기 때문
					continue;
				}

				used[i] = true; // 현재 레벨에서만 true로 변경
				sb.append(charArr[i]); // 해당 하위노드를 방문하기 전 문자열을 붙임

				backtrack(sb, charArr, used);

				sb.deleteCharAt(sb.length() - 1); // 방문 후 문자열을 제거
				used[i] = false; // 현재 레벨이 끝나면 false로 변경
				// false로 변경하고 빠져나옴으로써 다른 상위 레벨에서 해당 알바벳을 사용할 수 잇도록 함
			}
		}
	}
}
