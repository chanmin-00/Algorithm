import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

	static boolean[] visited;
	static HashMap<Integer, Integer> map = new HashMap<>();

	// 직속 상사는 1명일 수 밖에 없다.
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // 회사의 직원 수 n
		int m = Integer.parseInt(input[1]); // 최초의 칭찬 회수 m

		List<List<Integer>> myBuhaList = new ArrayList<>();
		List<List<Integer>> congratulationList = new ArrayList<>();

		input = reader.readLine().split(" ");
		for (int i = 0; i <= n; i++) {
			myBuhaList.add(new ArrayList<>());
			congratulationList.add(new ArrayList<>());
		}
		for (int i = 1; i < n; i++) {
			int myBossIndex = Integer.parseInt(input[i]);
			myBuhaList.get(myBossIndex).add(i + 1);
		}

		for (int i = 0; i < m; i++) {
			input = reader.readLine().split(" ");
			congratulationList.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
		}

		visited = new boolean[n + 1];
		map.put(1, 0);

		dfs(myBuhaList, congratulationList, 1);

		for (int i = 1; i <= n; i++) {
			System.out.print(map.get(i) + " ");
		}
	}

	public static void dfs(List<List<Integer>> myBuhaList, List<List<Integer>> congratulationList, int nowIndex) {
		visited[nowIndex] = true;

		List<Integer> childList = myBuhaList.get(nowIndex);

		int child;
		int tmpVal;
		for (int i = 0; i < childList.size(); i++) {
			child = childList.get(i);

			if (visited[child]) {
				continue;
			}

			List<Integer> tmpList = congratulationList.get(child);

			if (!tmpList.isEmpty()) {
				tmpVal = map.get(nowIndex);

				for (int j = 0; j < tmpList.size(); j++) {
					tmpVal += tmpList.get(j);
				}

				map.put(child, tmpVal);
			} else {
				tmpVal = map.get(nowIndex);
				map.put(child, tmpVal);
			}

			dfs(myBuhaList, congratulationList, child);
		}
	}
}
