import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static String[] input;

	static class Document {
		int index; // 몇 번째 문서인지
		int importance;

		public Document(int index, int importance) {
			this.index = index;
			this.importance = importance;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(reader.readLine()); // 테스트 케이스의 개수

		for (int i = 0; i < T; i++) {
			input = reader.readLine().split(" ");

			int N = Integer.parseInt(input[0]); // 문서의 개수 N
			int M = Integer.parseInt(input[1]); // 몇 번째로 인쇄가 되었는지 궁금한 문서 M, 맨 왼쪽은 0번째
			int importance;
			int cnt = 0; // 몇 번째로 큐에서 나오는지 카운트

			Queue<Document> queue = new LinkedList<>();
			Queue<Integer> priorityQueue = new PriorityQueue<>((i1, i2) -> i2 - i1);

			if (N == 1) {
				reader.readLine();
				System.out.println(1);
				continue;
			}

			input = reader.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				importance = Integer.parseInt(input[j]);

				queue.offer(new Document(j, importance)); // 큐에 일단 순서대로 문서 삽입
				priorityQueue.offer(importance);

			}

			while (!queue.isEmpty()) {
				Document document = queue.poll();

				if (document.importance < priorityQueue.peek()) {
					queue.offer(document);
				}
				else if (document.importance >= priorityQueue.peek() && document.index != M){
					cnt++;
					priorityQueue.poll();
				}
				else if (document.importance >= priorityQueue.peek() && document.index == M) {
					cnt++;
					System.out.println(cnt);
					break;
				}
			}
		}
	}
}
