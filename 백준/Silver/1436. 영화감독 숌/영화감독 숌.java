import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 666이 포함된 숫자들의 대/소를 비교하는 규칙을 잘 모르겠음
	// N은 1~10000까지의 자연수 중 하나이다. 시간 제한은 2초로 널널하다.
	// 그러면 N번째가 채워질때까지 숫자를 키워가며, 666이라는 문자열이 포함되는지 파악해보면 될거 같다.3
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine()); // N번째 영화

		int count = 0;
		int intNum = 666;
		while (true) {
			String strNum = intNum + "";

			if (strNum.contains("666")) {
				count++;
				if (count == N) {
					System.out.println(strNum);
					break;
				}
			}

			intNum++;
		}

	}
}
