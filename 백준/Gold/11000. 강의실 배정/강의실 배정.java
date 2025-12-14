import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static int N; // 수업의 개수
	static int result = 0;

	static class Class {
		int start;
		int end;

		public Class(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(reader.readLine());

		List<Class> classList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			input = reader.readLine().split(" ");

			classList.add(new Class(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}

		Collections.sort(classList, (c1, c2) -> {
			if (c1.start != c2.start) {
				return c1.start - c2.start;
			} else {
				return c1.end - c2.end;
			}
		});

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			if (queue.isEmpty()) {
				result++;
				queue.offer(classList.get(i).end);
			}
			else {
				if (queue.peek() <= classList.get(i).start) {
					queue.poll();
					queue.offer(classList.get(i).end);
				}
				else {
					queue.offer(classList.get(i).end);
					result++;
				}
			}
		}

		System.out.println(result);

	}
}
