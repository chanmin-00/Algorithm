import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(reader.readLine());

		for (int i = 0; i < T; i++) {
			int page = Integer.parseInt(reader.readLine());
			PriorityQueue<Long> queue = new PriorityQueue<>();

			String[] input = reader.readLine().split(" ");
			for (int j = 0; j < page; j++) {
				queue.offer(Long.parseLong(input[j]));
			}

			long sum = 0;
			while (!queue.isEmpty()) {
				if (queue.size() > 1) {
					long num1 = queue.poll();
					long num2 = queue.poll();

					sum += (num1 + num2);
					queue.offer(num1 + num2);
				}
				else {
					queue.poll();
				}
			}

			System.out.println(sum);

		}
	}

}
