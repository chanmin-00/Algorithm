import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine()); // 전체 케이스의 개수
		int cnt = 1;

		for (int i = 0; i < N; i++) {
			String[] input = reader.readLine().split(" ");

			Stack<String> stack = new Stack<>();

			// System.out.println("length : " + input.length);

			for (int j = 0; j < input.length; j++) {
				stack.push(input[j]);
			}

			System.out.print("Case #" + cnt + ": ");

			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}

			System.out.println();
			cnt++;
		}
	}
}
