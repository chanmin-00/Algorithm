import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

	static class Photo {
		int cnt; // 추천 횟수
		int order; // 게시된 순서

		public Photo(int cnt, int order) {
			this.cnt = cnt;
			this.order = order;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input[];

		int N = Integer.parseInt(reader.readLine()); // 사진 틀의 개수
		int totalCnt = Integer.parseInt(reader.readLine()); // 전체 학생의 총 추천 횟수
		HashMap<Integer, Photo> photoHashMap = new HashMap<>();

		int postOrder = 1; // 게시 순

		input = reader.readLine().split(" ");

		for (int i = 0; i < totalCnt; i++) {
			int num = Integer.parseInt(input[i]); // 추천받은 학생 번호

			if (photoHashMap.containsKey(num)) {
				int oldCnt = photoHashMap.get(num).cnt;
				int oldOrder = photoHashMap.get(num).order;

				photoHashMap.put(num, new Photo(oldCnt + 1, oldOrder));

			} else if (!photoHashMap.containsKey(num) && photoHashMap.size() < N) {
				postOrder++;
				photoHashMap.put(num, new Photo(0, postOrder));
			} else if (!photoHashMap.containsKey(num) && photoHashMap.size() == N) {
				// map 정렬하는 법
				List<Integer> keySet = new ArrayList<>(photoHashMap.keySet());
				Collections.sort(keySet, (value1, value2) -> {
					if (photoHashMap.get(value1).cnt != photoHashMap.get(value2).cnt) {
						return photoHashMap.get(value1).cnt - photoHashMap.get(value2).cnt;
					} else {
						return photoHashMap.get(value1).order - photoHashMap.get(value2).order;
					}
				});

				photoHashMap.remove(keySet.get(0)); // 제거

				postOrder++;
				photoHashMap.put(num, new Photo(0, postOrder));
			}
		}

		List<Integer> keySet = new ArrayList<>(photoHashMap.keySet());
		Collections.sort(keySet);

		for (Integer key : keySet) {
			System.out.print(key + " ");
		}
	}
}
