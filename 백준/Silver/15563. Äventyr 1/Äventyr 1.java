import java.util.*;
import java.io.*;

public class Main {

	// 시간축 : 정점
	// 트리 상에서의 간선 : 두 시간축 사이를 오갈 수 있음
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] input = reader.readLine().split(" ");
		StringBuilder result = new StringBuilder("");

		int N = Integer.parseInt(input[0]); // 시간축의 개수
		int Q = Integer.parseInt(input[1]); // 수행해야 하는 쿼리의 개수

		Set<Integer> numSet = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			numSet.add(i);
		}

		input = reader.readLine().split(" ");

		// HashSet은 정렬되지 않는다.
		// 정렬된 Set을 사용하기 위해서는 TreeSet을 사용해야 한다.
		// TreeSet 자료구조의 floor, celling 메소드를 사용하자.
		TreeSet<Integer> hasVio = new TreeSet<>();

		for (int i = 0; i < Q; i++) {
			input = reader.readLine().split(" ");

			int oneOrTwo = Integer.parseInt(input[0]);
			int num = Integer.parseInt(input[1]);

			if (oneOrTwo == 1) {
				hasVio.add(num);
			} else {
				int closeLeft = 1;
				int closeRight = N;
				int min = Integer.MAX_VALUE;

				if (!hasVio.isEmpty()) {
					if (hasVio.floor(num ) != null) {
						closeLeft = Math.abs(hasVio.floor(num) - num); // num 이하의 값 중 가장 큰 값을 가져옴
						min = Math.min(closeLeft, min);
					}

					if (hasVio.ceiling(num) != null) {
						closeRight = Math.abs(hasVio.ceiling(num) - num); // num 이상의 값 중 가장 작은 값을 가져옴
						min = Math.min(closeRight, min);
					}

					result.append(min + "\n");
				}
				else {
					result.append("-1" + "\n");
				}
			}

		}

		System.out.println(result);
	}
}
