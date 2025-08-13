import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int[] vCntArr;

	// 이 문제는 서브트리에 속한 정점의 수를 구하는 문제
	// 매 쿼리마다 서브트리의 정점을 구하면 시간초과, 메모리 낭비
	// 각 정점마다 정보를 저장하고 있어야 함
	// 각 서브트리의 정점의 수의 합은 자식노드 정점들의 합 + 1
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");
		String inputStr;

		int N = Integer.parseInt(input[0]); // 트리의 정점의 수
		int R = Integer.parseInt(input[1]); // 루트의 번호
		int Q = Integer.parseInt(input[2]); // 쿼리의 수
		int u, v; // 정점 정보

		boolean[] visited = new boolean[N + 1];
		vCntArr = new int[N + 1];
		List<List<Integer>> vList = new ArrayList<>(N + 1); // 정점 정보를 담는 리스트 초기화

		// 초기화 작업
		for (int i = 0; i <= N; i++) {
			vList.add(new ArrayList<>());
			vCntArr[i] = 1; // 자기 자신은 포함
		}

		for (int i = 0; i < N - 1; i++) {
			input = reader.readLine().split(" ");
			u = Integer.parseInt(input[0]);
			v = Integer.parseInt(input[1]);

			vList.get(v).add(u);
			vList.get(u).add(v);
		}

		countV(vList, R, visited);

		for (int i = 0; i < Q; i++) {
			inputStr = reader.readLine();
			int num = Integer.parseInt(inputStr);

			System.out.println(vCntArr[num]);
		}

	}

	public static int countV(List<List<Integer>> vList, int vIndex, boolean[] visited) {
		visited[vIndex] = true; // 방문을 했기 때문에 true로 변경

		List<Integer> edgeList = vList.get(vIndex);
		int edgeCnt = edgeList.size();

		for (int i = 0; i < edgeCnt; i++) {
			int v = edgeList.get(i);

			if (visited[v]) {
				continue;
			}

			vCntArr[vIndex] += countV(vList, v, visited);
		}

		return vCntArr[vIndex];
	}
}
