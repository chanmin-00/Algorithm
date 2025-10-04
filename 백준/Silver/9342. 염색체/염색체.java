import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(reader.readLine());

		for (int i = 0; i < T; i++) {
			String str = reader.readLine();

			boolean result = rule(str);

			if (result) {
				System.out.println("Infected!");
			} else {
				System.out.println("Good");
			}
		}
	}

	public static boolean rule(String str) {
		int nextIndex = 0;
		int aCount = 0;
		int fCount = 0;
		int cCount = 0;

		char c = str.charAt(0);

		if (c == 'A') {
			aCount++;
			nextIndex++;
		} else if (c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F') {
			nextIndex++;
		}

		while (true) {
			if (nextIndex < str.length() && str.charAt(nextIndex) == 'A') {
				nextIndex++;
				aCount++;
			} else {
				break;
			}
		}

		if (aCount == 0) {
			return false;
		}

		while (true) {
			if (nextIndex < str.length() && str.charAt(nextIndex) == 'F') {
				nextIndex++;
				fCount++;
			} else {
				break;
			}
		}

		if (fCount == 0) {
			return false;
		}

		while (true) {
			if (nextIndex < str.length() && str.charAt(nextIndex) == 'C') {
				nextIndex++;
				cCount++;
			} else {
				break;
			}
		}

		if (cCount == 0) {
			return false;
		}

		if (nextIndex == str.length()) {
			return true;
		}

		char lastC = str.charAt(nextIndex);
		if (nextIndex + 1 == str.length()) {
			if (lastC == 'A' || lastC == 'B' || lastC == 'D' || lastC == 'E' || lastC == 'F') {
				return true;
			}
		}

		return false;
	}
}
