import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr;

		int n = Integer.parseInt(reader.readLine()); // 과제의 개수
		int d; // 과제 마감일까지 남은 일수
		int w; // 과제의 점수

		int maxSum = 0; // 최대 과제 점수

		// 자바의 우선순위 큐 자료구조 활용
		List<PriorityQueue<Integer>> queueList = new ArrayList<>(1001);
		for (int i = 0; i < 1001; i++) {

			// 최대 힙 구조를 가진 우선순위 큐 자료구조 생성
			queueList.add(new PriorityQueue<>(Comparator.reverseOrder()));
		}

		for (int i = 0; i < n; i++) {
			inputArr = reader.readLine().split(" ");

			d = Integer.parseInt(inputArr[0]);
			w = Integer.parseInt(inputArr[1]);

			for (int j = 1; j <= d; j++) {
				queueList.get(j).add(w);
			}
		}

		for (int i = n; i >= 1; i--) {
			int maxValue;

			if (!queueList.get(i).isEmpty()) {
				maxValue = queueList.get(i).poll(); // 최대 힙의 루트 노드에서 가장 큰 값을 추출

				maxSum += maxValue;

				for (int j = 1; j < i; j++) {
					queueList.get(j).remove(Integer.valueOf(maxValue)); // maxValue의 값과 동일한 단 하나의 요소만 제거
				}
			}
		}

		System.out.println(maxSum);

	}
}
