import java.io.*;
import java.util.*;

// 왼손 검지손가락은 자음
// 오른족 검지손가락은 모음
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;

	static class V {
		int x;
		int y;

		public V(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static HashSet<String> set = new HashSet<>(); // 모음쪽 자음
	static HashMap<String, V> map = new HashMap<>();

	static int x1 = 0;
	static int y1 = 0;
	static int x2 = 0;
	static int y2 = 0;

	static String str = "";
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		set.add("y");
		set.add("u");
		set.add("i");
		set.add("o");
		set.add("p");
		set.add("h");
		set.add("j");
		set.add("k");
		set.add("l");
		set.add("b");
		set.add("n");
		set.add("m");

		map.put("z", new V(0, 0));
		map.put("x", new V(0, 1));
		map.put("c", new V(0, 2));
		map.put("v", new V(0, 3));
		map.put("b", new V(0, 4));
		map.put("n", new V(0, 5));
		map.put("m", new V(0, 6));
		map.put("a", new V(1, 0));
		map.put("s", new V(1, 1));
		map.put("d", new V(1, 2));
		map.put("f", new V(1, 3));
		map.put("g", new V(1, 4));
		map.put("h", new V(1, 5));
		map.put("j", new V(1, 6));
		map.put("k", new V(1, 7));
		map.put("l", new V(1, 8));
		map.put("q", new V(2, 0));
		map.put("w", new V(2, 1));
		map.put("e", new V(2, 2));
		map.put("r", new V(2, 3));
		map.put("t", new V(2, 4));
		map.put("y", new V(2, 5));
		map.put("u", new V(2, 6));
		map.put("i", new V(2, 7));
		map.put("o", new V(2, 8));
		map.put("p", new V(2, 9));

		input = reader.readLine().split(" ");

		// 왼손 검지손가락 - 자음
		x1 = map.get(input[0]).x;
		y1 = map.get(input[0]).y;

		// 오른쪽 검지손가락 - 모음
		x2 = map.get(input[1]).x;
		y2 = map.get(input[1]).y;

		str = reader.readLine();

		for (int i = 0; i < str.length(); i++) {
			String tmpStr = str.charAt(i) + "";

			if (set.contains(tmpStr)) { // 모음쪽 자음인 경우
				int newX2 = map.get(tmpStr).x;
				int newY2 = map.get(tmpStr).y;

				answer += 1;
				answer += (Math.abs(x2 - newX2) + Math.abs(y2 - newY2));

				x2 = newX2;
				y2 = newY2;
			} else {
				int newX1 = map.get(tmpStr).x;
				int newY1 = map.get(tmpStr).y;

				answer += 1;
				answer += (Math.abs(x1 - newX1) + Math.abs(y1 - newY1));

				x1 = newX1;
				y1 = newY1;
			}
		}

		System.out.println(answer);
	}

}
