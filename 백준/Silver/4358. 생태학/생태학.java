import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String str;

		TreeMap<String, Integer> tree = new TreeMap<>(); // 기본적으로 키 값이 사전순으로 정렬된
		int total = 0;

		while (sc.hasNext()) {
			str = sc.nextLine();
			total++;

			if (!tree.containsKey(str)) {
				tree.put(str, 1);
			} else {
				tree.put(str, tree.get(str) + 1);
			}
		}

		Set<String> keySet = tree.keySet();

		for (String key : keySet) {
			double percent = ((double)tree.get(key) / total) * 100;
			String result = String.format("%.4f", percent);

			System.out.println(key + " " + result);
		}

	}
}
