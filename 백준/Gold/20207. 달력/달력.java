import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	static class Schedule {
		int startDay;
		int endDay;

		public Schedule(int startDay, int endDay) {
			this.startDay = startDay;
			this.endDay = endDay;
		}
	}

	// 시작일이 가장 앞선 일정부터 차례대로 채워진다.
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int n = Integer.parseInt(reader.readLine()); // 일정의 개수 n
		boolean[][] calendar = new boolean[n + 1][366];
		int sum = 0; /// 결과값

		Queue<Schedule> scheduleQueue = new PriorityQueue<>(
			(s1, s2) -> {
				if (s1.startDay != s2.startDay) {
					return s1.startDay - s2.startDay; // 시작일이 가장 앞선 순으로 오름차순
				} else {
					return s2.endDay - s1.endDay; // 시작일이 같을 경우 기간이 가장 긴 순으로
				}
			}
		);

		for (int i = 0; i < n; i++) {
			input = reader.readLine().split(" ");

			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);

			scheduleQueue.offer(new Schedule(start, end));
		}

		boolean startFlag = true;
		int startWidth = 0; // 코팅지 가로 시작 인덱스
		int endWidth = 0; // 코팅지 가로 끝 인덱스
		int height = 0; // 코팅지 세로 길이
		int tmpSum = 0;

		while (!scheduleQueue.isEmpty()) {
			Schedule schedule = scheduleQueue.poll();
			int start = schedule.startDay;
			int end = schedule.endDay;
			int myHeight = 1;

			if (startFlag) { // 처음 일정의 경우에 대해서만 처리
				for (int i = start; i <= end; i++) {
					calendar[1][i] = true;
				}
				startWidth = start;
				endWidth = end;
				height = 1;

				startFlag = false;

			} else { // 처음이 아닌 경우
				while (true) { // 일정이 겹치는지 확인
					if (calendar[myHeight][start]) {
						myHeight++;
					} else {
						break;
					}
				}

				for (int i = start; i <= end; i++) { // 달력에 대해 일정 채워넣기
					calendar[myHeight][i] = true;
				}

				if (myHeight == 1 && endWidth + 1 < start) { // 새로운 코팅지가 필요한 경우
					sum += height * (endWidth - startWidth + 1); // 이전 코팅지 크기를 더해줌

					// 값 갱신
					startWidth = start;
					endWidth = end;
					height = 1;
				} else { // 기존의 코팅지를 활용해야 하는 경우
					if (myHeight > height) {
						height = myHeight;
					}
					if (end > endWidth) {
						endWidth = end;
					}
				}
			}

			tmpSum = height * (endWidth - startWidth + 1); // 새로운 코팅지가 필요한 경우에 대한 조건문을 만나고 끝난 경우를 계산하기 위함
		}

		System.out.println(sum + tmpSum);
	}
}
