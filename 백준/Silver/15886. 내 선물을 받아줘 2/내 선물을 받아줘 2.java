import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine()); // 골목길의 길이 N
		String str = reader.readLine();
		int cnt = 0;

		while (true) {
			if (str.contains("EW")) {
				str = str.replaceFirst("EW", "XX");
				cnt++;
			}
			else {
				break;
			}
			// System.out.println(str);
		}

		System.out.println(cnt);

	}

}
