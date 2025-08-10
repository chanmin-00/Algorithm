import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	// 트럭이 지나가는 순서는 바꿀 수 없다.
	// 다리 위에는 단지 w대의 트럭만 동시에 올라갈 수 있다.
	// 동시에 다리 위에 올라갈 수 있는 트럭들의 무게의 합은 다리의 최대하중인 L보다 작거나 같아야 한다.
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = reader.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // 다리를 건너는 트럭의 수
		int w = Integer.parseInt(input[1]); // 다리의 길이
		int L = Integer.parseInt(input[2]); // 다리의 최대 하중
		int[] truck = new int[n];

		input = reader.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			truck[i] = Integer.parseInt(input[i]);
		}

		int time = 0; // 현재까지 걸린 시간 정보 저장
		int weight = 0; // 다리 위에 트럭들의 무게의 합 정보
		int index = 0; // 몇번째 트럭 차례인지 정보를 나타냄

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			queue.offer(0);
		}

		while (!queue.isEmpty()) {
			time++; // 시간 증가
			weight -= queue.poll();

			if (index < n && truck[index] + weight <= L) {
				queue.offer(truck[index]);
				weight += truck[index];
				index++;
			} else if (index < n) {
				queue.offer(0);
			}
		}

		System.out.println(time);

	}
}
