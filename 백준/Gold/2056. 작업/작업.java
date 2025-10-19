import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine()); // 작업의 수
		int[] inputArr = new int[N + 1];
		int[] valueArr = new int[N + 1];
		boolean[] visitedArr = new boolean[N + 1];
		Set<Integer>[] setArr = new HashSet[N + 1];

		for (int i = 1; i <= N; i++) {
			String[] input = reader.readLine().split(" ");

			int value = Integer.parseInt(input[0]);

			valueArr[i] = value;

			int cnt = Integer.parseInt(input[1]);

			setArr[i] = new HashSet<>();
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(input[j + 2]);

				setArr[i].add(num);
				inputArr[num]++;
			}
		}

		int size = 0;
		int time = 0;

		while (size < N) {
			time++;
			Set<Integer> tmp = new HashSet<>();

			for (int i = 1; i <= N; i++) {
				if (inputArr[i] == 0 && visitedArr[i] == false) {
					tmp.add(i);
				}
			}

			for (Integer key : tmp) {
				valueArr[key]--;

				if (valueArr[key] == 0) {
					for (Integer setKey : setArr[key]) {
						inputArr[setKey]--;
					}
					visitedArr[key] = true;
					size++;
				}
			}

		}

		System.out.println(time);
	}
}
