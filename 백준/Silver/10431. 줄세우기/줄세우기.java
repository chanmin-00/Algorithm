import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int P = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < P; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken()); // 테스트케이스 번호

			int[] line = new int[20];
			int size = 0;   // 현재 줄에 서 있는 학생 수
			int count = 0;  // 뒤로 물러난 총 횟수

			for (int i = 0; i < 20; i++) {
				int h = Integer.parseInt(st.nextToken());

				// 삽입 위치 찾기 (뒤에서부터)
				int j = size - 1;
				while (j >= 0 && line[j] > h) {
					line[j + 1] = line[j]; // 뒤로 밀기
					count++;
					j--;
				}
				line[j + 1] = h;
				size++;
			}

			sb.append(T).append(" ").append(count).append("\n");
		}

		System.out.print(sb);
	}
}
