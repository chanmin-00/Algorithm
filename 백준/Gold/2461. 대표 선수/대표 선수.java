import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	public static class Student {
		int cls; // 학생의 반
		int num; // 학생의 능력치

		public Student(int cls, int num) {
			this.cls = cls;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // 반의 수
		int m = Integer.parseInt(input[1]); // 반 당 학생의 수

		List<int[]> arrList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arrList.add(new int[m]);
		}

		PriorityQueue<Student> queue = new PriorityQueue<>((s1, s2) -> {
			return s1.num - s2.num;
		});

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int result;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			input = reader.readLine().split(" ");

			for (int j = 0; j < m; j++) {
				arrList.get(i)[j] = Integer.parseInt(input[j]);
			}

			Arrays.sort(arrList.get((i)));

			queue.offer(new Student(i, arrList.get(i)[0]));

			if (arrList.get(i)[0] > max) {
				max = arrList.get(i)[0];
			}
			if (arrList.get(i)[0] < min) {
				min = arrList.get(i)[0];
			}

			map.put(i, 0);
		}

		result = max - min;

		while (true) {
			Student student = queue.poll();
			int classNum = student.cls;
			int index = map.get(classNum) + 1;

			if (index == m) {
				break;
			}

			queue.offer(new Student(classNum, arrList.get(classNum)[index]));
			map.put(classNum, index);

			if (max < arrList.get(classNum)[index]) {
				max = arrList.get(classNum)[index];
			}

			min = queue.peek().num;
			
			// System.out.println("max : "  + max);
			// System.out.println("min : "  + min);

			if (result > (max - min)) {
				result = max - min;
			}
		}

		System.out.println(result);
	}
}
