import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String sound = reader.readLine();
		StringBuilder stringBuilder = new StringBuilder(sound);

		int cnt = 0;

		if (sound.length() % 5 != 0) {
			System.out.println(-1);
			return;
		}

		while (!stringBuilder.isEmpty()) {
			int size = stringBuilder.length();
			int index = 0;
			boolean flag = false;
			boolean[] visited = new boolean[size];

			for (int i = 0; i < size; i++) {
				if ((index % 5 == 0) && stringBuilder.charAt(i) == 'q') {
					visited[i] = true;
					index++;
					flag = true;
				} else if ((index % 5 == 1) && stringBuilder.charAt(i) == 'u') {
					visited[i] = true;
					index++;
					flag = true;
				} else if ((index % 5 == 2) && stringBuilder.charAt(i) == 'a') {
					visited[i] = true;
					index++;
					flag = true;
				} else if ((index % 5 == 3) && stringBuilder.charAt(i) == 'c') {
					visited[i] = true;
					index++;
					flag = true;
				} else if ((index % 5 == 4) && stringBuilder.charAt(i) == 'k') {
					visited[i] = true;
					index++;
					flag = true;
				}
			}

			if (index % 5 == 0 && flag == true) {
				cnt++;
				StringBuilder stringBuilder1 = new StringBuilder();

				for (int i = 0; i < size; i++) {
					if (!visited[i]) {
						stringBuilder1.append(stringBuilder.charAt(i));
					}
				}

				stringBuilder = stringBuilder1;

			}
			else {
				cnt = -1;
				break;
			}

		}

		System.out.println(cnt);

	}
}
