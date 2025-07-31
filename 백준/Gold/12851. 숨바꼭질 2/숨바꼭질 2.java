import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Pair {
		int n; // 현재 수빈이의 위치
		int depth; // 노드 깊이

		public Pair(int n, int depth) {
			this.n = n;
			this.depth = depth;
		}
	}

	// 수빈이가 동생을 찾는다.
	// 수빈이는 1초에 1씩 이동 가능하다. x + 1, x -1;
	// 순간이동을 하면 1초에 2 * x 의 위치로 이동 가능하다.
	// 가장 빠른 시간으로 찾는게 몇 초인지, 그리고 가지수는 몇개인지
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // 수빈이의 위치
		int k = Integer.parseInt(input[1]); // 동생의 위치

		int sec = Integer.MAX_VALUE; // 가장 빠른 시간 안에 찾는 초수
		int cnt = 0; // 가지 수

		boolean[] visited = new boolean[100001]; // 노드 방문 여부 정보를 저장할 배열

		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(n, 0));

		while (!queue.isEmpty()) {
			Pair nowPair = queue.poll(); // 수빈이의 현재 위치를 추출
			visited[nowPair.n] = true;

			if (nowPair.depth > sec) {
				continue;
			}

			if (nowPair.n != k) {
				int nowN = nowPair.n;

				if (nowN > 0 && !visited[nowN - 1]) { // 진입하기 전 방문 여부를 먼저 체크
					queue.offer(new Pair(nowN - 1, nowPair.depth + 1));
				}
				if (nowN < 100000 && !visited[nowN + 1]) {
					queue.offer(new Pair(nowN + 1, nowPair.depth + 1));
				}
				if (nowN * 2 <= 100000 && !visited[nowN * 2]) {
					queue.offer(new Pair(nowN * 2, nowPair.depth + 1));
				}
			} else {
				sec = nowPair.depth;
				cnt++;
			}
		}

		System.out.println(sec);
		System.out.println(cnt);
	}
}
