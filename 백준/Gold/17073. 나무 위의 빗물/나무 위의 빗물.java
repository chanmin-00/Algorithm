import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	// 주어지는 루트의 트리는 항상 1번 정점이다.

	// 리프 노드를 만날 때까지 물은 계속 흘러 내려가야 한다.
	// 이 문제에서 구하고자 하는 값은 물이 고여있는 노드들에 대해서 물 양의 값이 평균을 구하면 된다.
	// 결국 물은 계속 아래로 흘러 내려가니까 리프노드에만 물이 고여있게 된다.
	// 리프노드의 개수를 구하면 된다.
	// 리프 정점의 경우에는 간선이 하나만 연결이 된다. 간선이 하나만 연결된 정점을 찾으면 된다.
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = reader.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // 트리의 노드 수
		int w = Integer.parseInt(input[1]); // 1번 노드에 고인 물의 양

		int leafCnt = 0; // 리프 노드의 개수

		List<LinkedList<Integer>> nodeList = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			nodeList.add(new LinkedList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			input = reader.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);

			nodeList.get(u).add(v);
			nodeList.get(v).add(u);
		}

		for (int i = 2; i <= n; i++) { // 1은 제외해야 한다. 무조건 루트 노드이기 때문이다.
			int size = nodeList.get(i).size();
			if (size == 1) {
				leafCnt++;
			}
		}

		double result = w / (double)leafCnt;
		System.out.println(result);
	}
}
