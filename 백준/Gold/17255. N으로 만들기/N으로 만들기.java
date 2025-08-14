import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	// 구하고자 하는 것 : 어떤 수 N을 만드는 방법의 수가 몇가지인
	// 숫자를 적는 과정에서 나온 수가 순서대로 같다면 모두 같은 방법이다.
	// 처음에 어떤 숫자 하나를 적고 만들어진 수의 왼쪽이나 오른쪽에 숫자를 계속 붙이면 어떤 수 N이든 만들 수 있다!!
	// 무조건 만들 수 있음을 의미
	// 중복 여부를 어떻게 판단해야 하지?

	static Set<String> set = new HashSet<>();
	static int length = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String N = reader.readLine();

		length = N.length();

		for (int i = 0; i < length; i++) {
			String str = N.charAt(i) + "";
			backtrack(N, str, str, i - 1, i + 1);
		}

		System.out.println(set.size());
	}

	public static void backtrack(String str, String tmp, String totalTmp, int leftIndex, int rightIndex) {
		if (tmp.length() == str.length()) {
			set.add(totalTmp);
		} else {

			int tmpLength = tmp.length();
			int totalTmpLength = totalTmp.length();

			if (leftIndex >= 0) {
				tmp = str.charAt(leftIndex) + tmp;
				totalTmp = totalTmp + tmp;
				leftIndex = leftIndex - 1;

				backtrack(str, tmp, totalTmp, leftIndex, rightIndex);

				leftIndex = leftIndex + 1;
				totalTmp = totalTmp.substring(0, totalTmpLength);
				tmp = tmp.substring(1);
			}

			if (rightIndex < str.length()) {
				tmp = tmp + str.charAt(rightIndex);
				totalTmp = totalTmp + tmp;
				rightIndex = rightIndex + 1;

				backtrack(str, tmp, totalTmp, leftIndex, rightIndex);

				rightIndex = rightIndex - 1;
				totalTmp = totalTmp.substring(0, totalTmpLength);
				tmp = tmp.substring(0, tmpLength);
			}
		}

	}
}
