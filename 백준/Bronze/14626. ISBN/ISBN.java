import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 10 - m - (a mod 10) - (3b mod 10) ... = * mod 10
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input = reader.readLine();
		int sum = 10;
		boolean odd = false;
		int result = 0;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c == '*') {
				if (i % 2 == 0) {
					odd = false;
				} else {
					odd = true;
				}
			} else {
				if ((i % 2) == 0) {
					sum += (Integer.parseInt(c + "") % 10);
				} else {
					sum += ((3 * Integer.parseInt(c + "")) % 10);
				}
			}
		}

		// System.out.println(sum);

		for (int i = 0; i <= 9; i++) {
			int tmp = sum;

			if (odd == false) {
				tmp += i;

				if (tmp % 10 == 0) {
					result = i;
					break;
				}
			} else {
				tmp += (3 * i);

				if (tmp % 10 == 0) {
					result = i;
					break;
				}
			}
		}

		System.out.println(result);
	}
}
