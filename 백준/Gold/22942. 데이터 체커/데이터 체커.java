import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {

	// 괄호 문제를 푼다고 생각하자. 스택으로 !!!
	static class Point implements Comparable<Point> {
		int pos;
		int index;

		@Override
		public int compareTo(Point other) {
			return Integer.compare(this.pos, other.pos);
		}

		public Point(int pos, int index) {
			this.pos = pos;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine()); // 원의 개수 n
		List<Point> pointList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] input = reader.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int r = Integer.parseInt(input[1]);

			pointList.add(new Point(x - r, i));
			pointList.add(new Point(x + r, i));
		}

		Collections.sort(pointList);
		Stack<Point> stack = new Stack<>();

		for (int i = 0; i < pointList.size(); i++) {
			if (stack.isEmpty()) {
				stack.push(pointList.get(i));
			} else {
				if (stack.peek().index == pointList.get(i).index) {
					stack.pop();
				} else {
					stack.push(pointList.get(i));
				}
			}
		}

		if (stack.isEmpty()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
