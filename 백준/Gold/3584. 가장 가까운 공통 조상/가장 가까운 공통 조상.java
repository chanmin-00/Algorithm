import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(reader.readLine()); // 테스트 케이스 개수

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine()); // 트리를 구성하는 노드의 수

			int[] tree = new int[n + 1]; // 정점의 부모 노드 정보를 저장할 배열

			for (int j = 1; j < n; j++) {
				String[] edge = reader.readLine().split(" ");
				int parentVertex = Integer.parseInt(edge[0]); // 부모 노드
				int childVertex = Integer.parseInt(edge[1]); // 자식 노드

				tree[childVertex] = parentVertex; // 자식노드에 해당하는 부모 노드의 정보 저장
			}

			String[] vertex = reader.readLine().split(" ");
			int vertex1 = Integer.parseInt(vertex[0]);
			int vertex2 = Integer.parseInt(vertex[1]);

			LinkedList<Integer> fatherList1 = getFatherList(vertex1, tree);
			LinkedList<Integer> fatherList2 = getFatherList(vertex2, tree);

			for (int j = 0; j < fatherList1.size(); j++) {
				int father1 = fatherList1.get(j);

				if (fatherList2.contains(father1)) {
					System.out.print(father1 + " ");
					break;
				}
			}
		}
	}

	public static LinkedList<Integer> getFatherList(int vertex, int[] tree) {
		LinkedList<Integer> fatherList = new LinkedList<>();
		fatherList.add(vertex);

		Queue<Integer> queue = new LinkedList<>();

		queue.offer(vertex);

		while (!queue.isEmpty()) {
			int child = queue.poll();
			int parent = tree[child];

			if (parent != 0) {
				fatherList.add(parent);
				queue.offer(parent);
			}
		}

		return fatherList;
	}

}
