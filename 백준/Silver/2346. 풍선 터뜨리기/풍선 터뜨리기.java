import java.io.*;
import java.util.*;

// 원형 큐
// 원형 큐이기 때문에 어느 곳이든 가장 앞이 될 수 있고, 가장 뒤가 될 수 있다.
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static int N;

	static class Node {
		short index;
		short val;

		public Node(short index, short val) {
			this.index = index;
			this.val = val;
		}
	}

	public static void main(String[] args) throws IOException {

		N = Short.parseShort(reader.readLine());
		Deque<Node> queue = new ArrayDeque<>();

		boolean flag = true;

		input = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				if (Integer.parseInt(input[i]) > 0) {
					flag = true;
				} else {
					flag = false;
				}
			}

			queue.offer(new Node((short) (i + 1), Short.parseShort(input[i])));
		}

		while (!queue.isEmpty()) {
			int front = 0;
			Node node = null;

			if (flag) {
				node = queue.poll();
				front = node.val;
			}
			else {
				node = queue.pollFirst();
				front = node.val;
			}

			System.out.print(node.index + " ");

			if (queue.isEmpty()) {
				break;
			}

			if (front > 0) {
				for (int i = 0; i < front - 1; i++) {
					Node tmp = queue.removeFirst();
					queue.offer(tmp);
				}
			} else if (front < 0) {
				for (int i = front; i < 0; i++) {
					Node tmp = queue.removeLast();
					queue.offerFirst(tmp);
				}
			}
		}

	}
}
