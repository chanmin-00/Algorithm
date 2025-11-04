import java.io.*;
import java.util.*;

public class Main {

	public static class Node implements Comparable<Node> {
		char color;
		int num;

		public Node(char color, int num) {
			this.color = color;
			this.num = num;
		}

		@Override
		public int compareTo(Node o) {
			return this.num - o.num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Node[] nodes = new Node[5];

		for (int i = 0; i < 5; i++) {
			String[] input = reader.readLine().split(" ");

			nodes[i] = new Node(input[0].charAt(0), Integer.parseInt(input[1]));
		}

		Arrays.sort(nodes);

		// 1번 조건
		if (nodes[0].color == nodes[1].color && nodes[1].color == nodes[2].color && nodes[2].color == nodes[3].color
			&& nodes[3].color == nodes[4].color) {

			boolean flag = true;
			for (int i = 0; i < 4; i++) {
				if (!((nodes[i].num + 1 == nodes[i + 1].num))) {
					flag = false;
				}
			}

			if (flag == true) {
				System.out.println(nodes[4].num + 900);
				return;
			}
		}

		// 2번 조건
		HashMap<Integer, Integer> hashMap2 = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			if (!hashMap2.containsKey(nodes[i].num)) {
				hashMap2.put(nodes[i].num, 1);
			} else {
				hashMap2.put(nodes[i].num, hashMap2.get(nodes[i].num) + 1);
			}
		}

		Set<Integer> keySet2 = hashMap2.keySet();
		for (Integer key : keySet2) {
			if (hashMap2.get(key) >= 4) {
				System.out.println(key + 800);
				return;
			}
		}

		// 3번 조건
		HashMap<Integer, Integer> hashMap3 = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			if (!hashMap3.containsKey(nodes[i].num)) {
				hashMap3.put(nodes[i].num, 1);
			} else {
				hashMap3.put(nodes[i].num, hashMap3.get(nodes[i].num) + 1);
			}
		}

		Set<Integer> keySet3 = hashMap2.keySet();
		int threeflag = 0;
		int twoflag = 0;
		for (Integer key : keySet3) {
			if (hashMap3.get(key) == 3) {
				threeflag = key;
			}
			if (hashMap3.get(key) == 2) {
				twoflag = key;
			}
		}

		if (threeflag != 0 && twoflag != 0) {
			System.out.println(10 * threeflag + twoflag + 700);
			return;
		}

		// 4번조건
		if (nodes[0].color == nodes[1].color && nodes[1].color == nodes[2].color && nodes[2].color == nodes[3].color
			&& nodes[3].color == nodes[4].color) {

			System.out.println(nodes[4].num + 600);
			return;
		}

		// 5번 조건
		boolean flag5 = true;
		for (int i = 0; i < 4; i++) {
			if (!((nodes[i].num + 1 == nodes[i + 1].num))) {
				flag5 = false;
			}
		}

		if (flag5 == true) {
			System.out.println(nodes[4].num + 500);
			return;
		}

		// 6번 조건
		HashMap<Integer, Integer> hashMap6 = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			if (!hashMap6.containsKey(nodes[i].num)) {
				hashMap6.put(nodes[i].num, 1);
			} else {
				hashMap6.put(nodes[i].num, hashMap6.get(nodes[i].num) + 1);
			}
		}

		Set<Integer> keySet6 = hashMap2.keySet();
		for (Integer key : keySet6) {
			if (hashMap6.get(key) >= 3) {
				System.out.println(key + 400);
				return;
			}
		}

		// 7번 조건
		HashMap<Integer, Integer> hashMap7 = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			if (!hashMap7.containsKey(nodes[i].num)) {
				hashMap7.put(nodes[i].num, 1);
			} else {
				hashMap7.put(nodes[i].num, hashMap7.get(nodes[i].num) + 1);
			}
		}

		Set<Integer> keySet7 = hashMap7.keySet();
		int firstTwo = 0;
		int secondTwo = 0;
		for (Integer key : keySet7) {
			if (hashMap7.get(key) == 2 && firstTwo == 0) {
				firstTwo = key;
			} else if (hashMap7.get(key) == 2 && firstTwo != 0) {
				secondTwo = key;
			}
		}

		if (firstTwo != 0 && secondTwo != 0 && firstTwo > secondTwo) {
			System.out.println(10 * firstTwo + secondTwo + 300);
			return;
		} else if (firstTwo != 0 && secondTwo != 0 && firstTwo < secondTwo) {
			System.out.println(10 * secondTwo + firstTwo + 300);
			return;
		}

		// 8번 조건
		HashMap<Integer, Integer> hashMap8 = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			if (!hashMap8.containsKey(nodes[i].num)) {
				hashMap8.put(nodes[i].num, 1);
			} else {
				hashMap8.put(nodes[i].num, hashMap8.get(nodes[i].num) + 1);
			}
		}

		Set<Integer> keySet8 = hashMap8.keySet();
		for (Integer key : keySet8) {
			if (hashMap8.get(key) >= 2) {
				System.out.println(key + 200);
				return;
			}
		}

		System.out.println(nodes[4].num + 100);

	}

}
