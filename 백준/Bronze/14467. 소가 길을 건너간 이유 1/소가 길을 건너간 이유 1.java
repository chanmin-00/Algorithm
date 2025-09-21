import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int result = 0;

		for (int i = 0; i < N; i++) {
			String[] input = reader.readLine().split(" ");
			int key = Integer.parseInt(input[0]);
			int newVal = Integer.parseInt(input[1]);

			if (hashMap.containsKey(key)) {
				int oldVal = hashMap.get(key);

				if (newVal != oldVal) {
					result++;
					hashMap.put(key, newVal);
				}
			}
			else {
				hashMap.put(key, newVal);
			}
		}


		System.out.println(result);
	}
}
