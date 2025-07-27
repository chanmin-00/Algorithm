import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	static class TwoNumber implements Comparable<TwoNumber> {
		int num1;
		int num2;

		@Override
		public int compareTo(TwoNumber other) {
			long thisSum = Math.abs(this.num1 + this.num2);
			long otherSum = Math.abs(other.num1 + other.num2);

			return Long.compare(thisSum, otherSum);
		}

		public TwoNumber(int num1, int num2) {
			this.num1 = num1;
			this.num2 = num2;
		}
	}

	// 문제는 두 용액의 합이 가장 0에 가까운 것을 찾는 것이다.
	// 전체 리스트 중에서 2개를 찾아야 한다.
	// 일단 절댓값 크기대로 정렬을 한다.
	// 절댓값 크기대로 정렬이 되었으므로, 인접한 것(인접한 것끼리가 실제로 가장 가깝다)끼리의 실제 합을 구해 그것을 절대값의 최소를 구한다.
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine()); // 전체 용액의 수
		Integer[] arr = new Integer[n];

		String[] input = reader.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr, Comparator.comparingInt(Math::abs));

		Queue<TwoNumber> twoNumberList = new PriorityQueue<>();
		for (int i = 0; i < n - 1; i++) {
			int num1;
			int num2;

			if (arr[i] < arr[i + 1]) {
				num1 = arr[i];
				num2 = arr[i + 1];
			} else {
				num1 = arr[i + 1];
				num2 = arr[i];
			}

			twoNumberList.add(new TwoNumber(num1, num2));
		}

		TwoNumber twoNumber = twoNumberList.poll();
		int num1 = twoNumber.num1;
		int num2 = twoNumber.num2;

		System.out.println(num1 + " " + num2);

	}

}
