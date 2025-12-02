import java.io.*;
import java.util.*;

// 구하고자 하는 것 : 선호도의 합을 채우면서 N개의 맥주를 모두 마실 수 있는 간 레벨의 최솟값
// 레벨의 최솟값, 레벨의 상한선이 있음
// 예를 들어, 간 레벨이 5라면 간 레벨 5보다 높은 거를 마시면 안 됨
// 간 레벨을 특정하고 나면, 거기서 선호도 높은 순으로 다 마시면 됨
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static int N; // 축제가 열리는 기간
	static int M; // 채워야 하는 선호도의 합
	static int K; // 마실수 있는 맥주 종류 수 (N <= K <= 200000)

	static class Beer {
		int level; // 도수 레벨
		int like; // 맥주의 선호도

		public Beer(int like, int level) {
			this.level = level;
			this.like = like;
		}
	}

	public static void main(String[] args) throws IOException {
		input = reader.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);

		List<Beer> beerList = new ArrayList<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < K; i++) {
			input = reader.readLine().split(" ");

			beerList.add(new Beer(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}

		Collections.sort(beerList, (b1, b2) -> {
			return b1.level - b2.level;
		});

		long sum = 0;
		int answer = -1;
		for (Beer beer : beerList) {
			minHeap.offer(beer.like);
			sum += beer.like;

			if (minHeap.size() > N) {
				 int out = minHeap.poll();
				 sum -= out;
			}

			if (minHeap.size() == N && sum >= M) {
				answer = beer.level;
				break;
			}
		}
		
		System.out.println(answer);

	}
}
