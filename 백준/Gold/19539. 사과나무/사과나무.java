import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 물을 X번 주면 항상 +1 성장 X번, +2 성장 X번이 동시에 일어남
	// => 따라서 전체 목표 합(S)은 반드시 3의 배수여야 함 (S = 3 * X)

	// 각 나무 높이 h는 h = 2*q + r (q = h // 2, r = h % 2)로 표현 가능
	// q = 그 나무가 최대한 받을 수 있는 2성장 횟수
	// r = 1성장으로만 채워야 하는 부분

	// 모든 나무에 대해 h // 2를 합하면
	// =>"전체적으로 가능한 최대 2성장 횟수"를 구할 수 있음

	// 실제 필요한 2 성장 횟수는 전체합 /3(즉,X)
	// 왜냐하면 X번 물을 주면 2성장은 정확히 X번 발생해야 하기 때문임

	// 따라서 조건은:
	// 1)전체합이 3의 배수일 것
	// 2)Σ(h // 2) >= S / 3 일 것
	// 둘 다 만족하면 YES, 아니면 NO

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int N = Integer.parseInt(reader.readLine()); // 뒷뜰에 심은 사과나무의 개수
		int[] hArr = new int[N + 1]; // 갊자가 바라는 i번째 나무의 높이

		int sum = 0;
		int twoCount = 0;

		input = reader.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			hArr[i] = Integer.parseInt(input[i - 1]);

			sum += hArr[i]; // 총 나무 길이의 합을 구하기 위함
			twoCount += hArr[i] / 2;
		}

		if (sum % 3 != 0) {
			System.out.print("NO");
		} else {
			if (twoCount >= (sum / 3)) {
				System.out.print("YES");
			} else {
				System.out.print("NO");
			}
		}
	}
}
