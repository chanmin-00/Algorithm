import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 문자열 자체를 저장하면 메모리 초과가 발생할 수 있으니,
// 문자열의 길이를 스택에 저장한다.
public class Main {

	// 아마도 스택 같은데?
	// K(Q) : K는 한 자리 정수, Q라는 문자열이 K번만큼 반복됨
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String str = reader.readLine(); // 압축된 문자열 str
		int prevStrLength = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = str.length() - 1; i >= 0; i--) {
			String tmp = str.charAt(i) + "";

			if (tmp.equals(")")) {
				stack.push(-1);
			} else if (tmp.equals("(")) {
				int innerStr = 0;
				int topStr = 0;
				while (true) {
					topStr = stack.pop();

					if (topStr == -1) {
						stack.push(innerStr);
						stack.push(-2);
						break;
					} else {
						innerStr += topStr; // 길이를 더함
					}
				}
			} else {
				if (!stack.isEmpty() && stack.peek() == -2) {
					stack.pop();
					int tarStrLength = stack.pop();
					int cnt = Integer.parseInt(tmp);

					int concatStrLength = 0;
					for (int j = 0; j < cnt; j++) {
						concatStrLength += tarStrLength;
					}
					stack.push(concatStrLength);
				} else {
					stack.push(1);
				}
			}
		}

		while (!stack.isEmpty()) {
			prevStrLength += stack.pop();
		}

		System.out.print(prevStrLength);
	}
}
