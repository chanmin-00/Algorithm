import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	static class Problem implements Comparable<Problem> {
		int number;
		int level;

		public Problem(int number, int level) {
			this.number = number;
			this.level = level;
		}

		// 문제 정렬을 위한 compareTo 오버라이딩
		@Override
		public int compareTo(Problem o) {
			if (this.level != o.level) {
				return this.level - o.level;
			} else {
				return this.number - o.number;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine()); // 추천 문제 리스트에 있는 문제의 개수
		List<Integer> result = new ArrayList<>();

		TreeSet<Problem> problemTreeSet = new TreeSet<>();
		Map<Integer, Integer> problemMap = new HashMap<>(); // 문제 번호를 가지고 난이도를 구하기 위한 Map

		for (int i = 0; i < n; i++) {
			String[] input = reader.readLine().split(" ");
			int number = Integer.parseInt(input[0]);
			int level = Integer.parseInt(input[1]);

			// TreeSet에 문제 정보 추가
			problemTreeSet.add(new Problem(number, level));

			// map에 문제 정보와 난이도 정보 추가
			problemMap.put(number, level);
		}

		int m = Integer.parseInt(reader.readLine()); // 입력될 명령문의 개수

		for (int i = 0; i < m; i++) {
			String[] input = reader.readLine().split(" ");
			if (input[0].length() == 9) { // recommend
				if (input[1].equals("1")) { // 가장 어려운 문제 번호를 출력

					Problem difficultProblem = problemTreeSet.last(); // 우선순위가 가장 낮은 어려운 문제 출력
					result.add(difficultProblem.number);
				} else if (input[1].equals("-1")) { // 가장 쉬운 문제 번호를 출력

					Problem easyProblem = problemTreeSet.first(); // 우선순위가 가장 높은 쉬운 문제 출력
					result.add(easyProblem.number);
				}

			} else if (input[0].length() == 3) { // add,
				int number = Integer.parseInt(input[1]);
				int level = Integer.parseInt(input[2]);

				problemTreeSet.add(new Problem(number, level));
				problemMap.put(number, level);

			} else {
				int number = Integer.parseInt(input[1]);
				int level = problemMap.get(number); // map에서 문제 번호를 통해 난이도 도출

				problemMap.remove(number); // map에서 삭제
				problemTreeSet.remove(new Problem(number, level));

			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			stringBuilder.append(result.get(i) + "\n");
		}
		System.out.println(stringBuilder);
	}
}
