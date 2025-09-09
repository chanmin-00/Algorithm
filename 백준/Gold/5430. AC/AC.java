import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int T = Integer.parseInt(reader.readLine());

		for (int i = 0; i < T; i++) {
			String method = reader.readLine(); // 함수가 이어진 문자열
			int n = Integer.parseInt(reader.readLine()); // 배열에 들어있는 수의 개수
			String numArr = reader.readLine();

			List<Integer> arr = new ArrayList<>();
			int leftIndex = 0;
			int rightIndex = n - 1;
			boolean left = true;
			boolean right = false;

			boolean isError = false;

			numArr = numArr.substring(1, numArr.length() - 1);
			input = numArr.split(",");

			for (int j = 0; j < n; j++) {
				arr.add(Integer.parseInt(input[j]));
			}

			for (int j = 0; j < method.length(); j++) {
				char character = method.charAt(j);

				if (character == 'R') {
					if (left) {
						left = false;
						right = true;
					} else {
						left = true;
						right = false;
					}
				} else {
					if (leftIndex > rightIndex) {
						isError = true;
						break;
					} else {
						if (left) {
							leftIndex++;
						} else {
							rightIndex--;
						}
					}
				}
			}

			if (isError) {
				System.out.println("error");
			} else {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("[");

				if (left) {
					for (int j = leftIndex; j <= rightIndex; j++) {
						stringBuilder.append(arr.get(j));
						if (j != rightIndex) {
							stringBuilder.append(",");
						}
					}
					stringBuilder.append("]");
				}
				else {
					for (int j = rightIndex; j >= leftIndex; j--) {
						stringBuilder.append(arr.get(j));
						if (j != leftIndex) {
							stringBuilder.append(",");
						}
					}
					stringBuilder.append("]");
				}

				System.out.println(stringBuilder);
			}

		}
	}
}
