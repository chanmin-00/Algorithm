import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder("");

		int N = Integer.parseInt(reader.readLine()); // 땅의 개수

		for (int i = 0; i < N; i++) {
			String[] input = reader.readLine().split(" ");

			int totalCnt = Integer.parseInt(input[0]);
			Map<Long, Integer> cntMap = new HashMap<>();

			int halfVal = totalCnt / 2 + 1;

			for (int j = 1; j < totalCnt + 1; j++) {
				long index = Long.parseLong(input[j]);

				if (!cntMap.containsKey(index)) {
					cntMap.put(index, 1);
				}
				else {
					int nowVal = cntMap.get(index);

					cntMap.put(index, ++nowVal);
				}
			}

			Set<Long> keySet = cntMap.keySet();
			boolean flag = false;
			for (Long key : keySet) {
				int val = cntMap.get(key);

				if (val >= halfVal) {
					result.append(key +"\n");
					flag = true;
					break;
				}
			}

			if (!flag) {
				result.append("SYJKGW\n");
			}

		}

		System.out.println(result);
	}
}
