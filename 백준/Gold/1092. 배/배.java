import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int N = Integer.parseInt(reader.readLine()); // 크레인의 개수
		Integer[] maxWeight = new Integer[N]; // 크레인의 무게 제한

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			maxWeight[i] = Integer.parseInt(input[i]);
		}

		int M = Integer.parseInt(reader.readLine()); // 박스의 개수
		List<Integer> boxWeight = new ArrayList<>(); // 박스의 무게

		input = reader.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			boxWeight.add(Integer.parseInt(input[i]));
		}

		Arrays.sort(maxWeight, Collections.reverseOrder()); // int 형 타입에는 적용 불가, 내림차순 정렬
		Collections.sort(boxWeight, Collections.reverseOrder());

		int result = 0;

		while (!boxWeight.isEmpty()) {
			int weight;
			int removeCnt = 0;

			for (int i = 0; i < N; i++) {
				int size = boxWeight.size();

				for (int j = 0; j < size; j++) {
					if (!boxWeight.isEmpty()) {
						weight = boxWeight.get(j);

						if (weight <= maxWeight[i]) {
							boxWeight.remove(j);
							removeCnt++;
							break;
						}
					}
				}
			}
			
			if (removeCnt == 0) {
				System.out.print(-1);
				return;
			}

			result++;
		}

		System.out.print(result);
	}
}
