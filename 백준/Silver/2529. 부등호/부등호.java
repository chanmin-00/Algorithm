import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int k; // 부등호 문자의 개수
	static String[] arr;
	static boolean[] visited = new boolean[10];

	static long min = Long.MAX_VALUE;
	static String minStr;
	static long max = Long.MIN_VALUE;
	static String maxStr;

	public static void main(String[] args) throws IOException {
		k = Integer.parseInt(reader.readLine());
		arr = reader.readLine().split(" ");

		for (int i = 0; i < 10; i++) {
			visited[i] = true;
			dfs(0, i + "", i);
			visited[i] = false;
		}

		System.out.println(maxStr);
		System.out.println(minStr);
	}

	public static void dfs(int index, String totalNum, int num) {
		if (index == k) {
			min = Math.min(min, Long.parseLong(totalNum));
			if (min == Long.parseLong(totalNum)) {
				minStr = totalNum;
			}
			max = Math.max(max, Long.parseLong(totalNum));
			if (max == Long.parseLong(totalNum)) {
				maxStr = totalNum;
			}

			return;
		}

		if (arr[index].equals(">")) {
			for (int i = 0; i < num; i++) {
				if (visited[i] == false) {

					visited[i] = true;
					String tmp = totalNum;
					totalNum += i;

					dfs(index + 1, totalNum, i);

					totalNum = tmp;
					visited[i] = false;
				}
			}
		}

		if (arr[index].equals("<")) {
			for (int i = num + 1; i < 10; i++) {
				if (visited[i] == false) {

					visited[i] = true;
					String tmp = totalNum;
					totalNum += i;

					dfs(index + 1, totalNum, i);

					totalNum = tmp;
					visited[i] = false;
				}
			}
		}
	}
}
