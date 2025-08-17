
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Main {

	static int pillarLength = 0;
	static int maxBrachLength = 0;
	static boolean branchStartFlag = false;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int N = Integer.parseInt(input[0]); // 노드의 개수
		int R = Integer.parseInt(input[1]); // 루트 노드의 번호
		int a, b, d;
		visited = new boolean[N + 1];

		List<HashMap<Integer, Integer>> nodeList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			nodeList.add(new HashMap<>());
		}

		for (int i = 0; i < N - 1; i++) {
			input = reader.readLine().split(" ");

			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			d = Integer.parseInt(input[2]);

			nodeList.get(a).put(b, d);
			nodeList.get(b).put(a, d);
		}

		dfs(nodeList, R, R, 0);

		if (!branchStartFlag) {
			pillarLength = maxBrachLength;
		}

		maxBrachLength -= pillarLength;
		System.out.print(pillarLength + " " + maxBrachLength);

	}

	public static void dfs(List<HashMap<Integer, Integer>> nodeList, int index, int R, int length) {

		visited[index] = true;

		HashMap<Integer, Integer> hashMap = nodeList.get(index);
		Set<Integer> keySet = hashMap.keySet();

		if ((keySet.size() > 2 && !branchStartFlag) || (keySet.size() > 1 && index == R)) {
			pillarLength = length;
			branchStartFlag = true;
		}

		if (keySet.size() == 1 && index != R) {
			if (length > maxBrachLength) {
				maxBrachLength = length;
			}
			return;
		}

		for (Integer key : keySet) {
			if (!visited[key]) {
				int tmp = hashMap.get(key);
				dfs(nodeList, key, R, length + tmp);
			}
		}
	}

}
