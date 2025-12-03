import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static int N; // 강의의 개수
	static PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>(); // 현재 강의가 진행 중인 강의실이 종료 시간 정보를 담은 큐

	public static class Class {
		int num;
		int start;
		int end;

		public Class(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(reader.readLine());

		List<Class> classList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			input = reader.readLine().split(" ");

			int num = Integer.parseInt(input[0]); // 강의실 번호
			int start = Integer.parseInt(input[1]); // 강의 시작 시간
			int end = Integer.parseInt(input[2]); // 강의 종료 시간

			classList.add(new Class(num, start, end));
		}

		Collections.sort(classList, (c1, c2) -> {
			return c1.start - c2.start;
		});

		for (int i = 0; i < N; i++) {

			if (!endTimeQueue.isEmpty()) {
				int min = endTimeQueue.peek(); // 종료 시간이 가장 작은거를 가져옴
				int currentEndTime = classList.get(i).end;

				if (min <= classList.get(i).start) {
					endTimeQueue.poll();
					endTimeQueue.offer(currentEndTime);
				}
				else {
					endTimeQueue.offer(currentEndTime);
				}
			}
			else {
				endTimeQueue.offer(classList.get(i).end);
			}
		}

		System.out.println(endTimeQueue.size());
	}
}
