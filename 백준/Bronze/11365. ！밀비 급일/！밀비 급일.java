import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String input = reader.readLine();

			if (input.equals("END")) {
				break;
			} else {
				StringBuilder str = new StringBuilder("");

				for (int i = input.length() - 1; i >= 0; i--) {
					str.append(input.charAt(i) + "");
				}

				System.out.println(str);
			}
		}
	}
}
