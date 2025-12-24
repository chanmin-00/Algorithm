import java.io.*;
import java.util.*;

// 집합이므로 union-find
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static int n; // N + 1개의 집합을 의미
	static int m; // 입력으로 주어지는 연산의 개수
	static int[] arr;
	static StringBuilder result = new StringBuilder("");

	public static int find(int v) { // 현재 자기가 포함된 집합의 루트를 반환
		int initV = v;
		
		while (arr[v] != v) {
			v = arr[v];
		}
		
		arr[initV] = v; // 경로를 압축시키기 위해서 바로 루트를 가리키도록 한다.

		return v;
	}

	public static void union(int v1, int v2) { // 두 집합을 합치겠다. 루트를 동일하게 만들겠다는 의미

		int root1 = find(v1);
		int root2 = find(v2);

		if (root1 <= root2) {
			arr[root2] = root1;
		}
		else {
			arr[root1] = root2;
		}
	}



	public static void main(String[] args) throws IOException {
		input = reader.readLine().split(" ");

		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		arr = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			arr[i] = i; // 첫 집합의 루트는 자기 자신
		}

		for (int i = 0; i < m; i++) {
			input = reader.readLine().split(" ");

			int zeroOrOne = Integer.parseInt(input[0]);

			int num1 = Integer.parseInt(input[1]);
			int num2 = Integer.parseInt(input[2]);

			if (zeroOrOne == 0) { // 두 집합을 합치겠다는 의미
				union(num1, num2);
			} else { // 두 집합이 같은 집합인지 확인하겠다
				int root1 = find(num1);
				int root2 = find(num2);

				if (root1 == root2) {
					result.append("YES\n");
				}
				else {
					result.append("NO\n");
				}
			}
		}

		System.out.println(result);
	}
}
