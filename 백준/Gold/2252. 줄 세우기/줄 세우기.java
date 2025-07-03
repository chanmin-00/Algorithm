import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] inputArr = reader.readLine().split(" ");
		int n = Integer.parseInt(inputArr[0]); // 학생들의 수
		int m = Integer.parseInt(inputArr[1]); // 키를 비교한 횟수

		// 위상 정렬의 경우 진입, 진출 차수의 수를 항상 판단해야 한다.

		// 각 노드(학생)들의 진입차수 정보를 담은 배열
		int[] inputDegree = new int[n + 1];

		// 인접 리스트 방식으로 간선 정보를 최적화해서 저장하도록 한다.
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>()); // 각 인덱스에 대해 new ArrayList로 초기화 필요
		}

		for (int i = 0; i < m; i++) {
			inputArr = reader.readLine().split(" ");
			int u = Integer.parseInt(inputArr[0]);
			int v = Integer.parseInt(inputArr[1]);

			graph.get(u).add(v); // u -> v 간선 정보 저장
			inputDegree[v]++; // v로 들어가는 진입차수 정보를 증가시킨다.
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (inputDegree[i] == 0) { // 집입차수가 0인 정점 먼저 삽입으로 초기화
				queue.offer(i);
				break;
			}
		}

		while (!queue.isEmpty()) {
			int u = queue.poll();
			inputDegree[u]--; // 0을 -1로 만들어서 다음 반복에 비교가 안되게 함.

			System.out.print(u + " ");

			// 진입차수가 0인 정점 u를 삭제시킬 것이기 때문에, u와 연결된 정점 v의 진입 차수를 1 감소시킴
			for (int i = 0; i < graph.get(u).size(); i++) {
				int v = graph.get(u).get(i);
				inputDegree[v]--;
			}

			// 다시 진입차수가 0인 정점을 찾아서 큐에 삽입
			for (int i = 1; i <= n; i++) {
				if (inputDegree[i] == 0) {
					queue.offer(i);
					break;
				}
			}
		}

	}

}