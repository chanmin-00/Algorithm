import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 1번 방법 - 반시계 - IN - 0
	// 2번 방법 - 시계 - OUT - 1
	// 기준 : 가운데를 기준으로 방향이 반대이어야 함
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(reader.readLine());

		for (int i = 0; i < T; i++) {
			String input = reader.readLine();

			if (input.length() % 2 == 0) {
				System.out.println("NO");
			} else if (input.length() == 1) {
				System.out.println("YES");
			}
			else {
				boolean result = divide(input);
				if (result) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
	}

	public static boolean divide(String str) {
		int len = str.length();

		if (len % 2 == 0) {
			return false;
		}

		if (len == 3) {
			if (str.charAt(0) == '0' && str.charAt(2) == '1') {
				return true;
			} else if (str.charAt(0) == '1' && str.charAt(2) == '0') {
				return true;
			} else {
				return false;
			}
		} else {
			boolean flag1 = divide(str.substring(0, len / 2));
			boolean flag2 = divide(str.substring(len / 2 + 1));

			boolean flag = true;
			if (flag1 && flag2) {
				for (int i = 0; i < len / 2; i++) {
					if (str.charAt(i) == str.charAt(len -i -1)) {
						flag = false;
						break;
					}
				}

				return flag;
			} else {
				return false;
			}
		}
	}
}
