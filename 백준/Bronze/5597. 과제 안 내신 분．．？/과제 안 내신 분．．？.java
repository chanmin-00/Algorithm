import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Set<Integer> student = new HashSet<>();
		for (int i = 0; i < 28; i++) {
			int num = Integer.parseInt(reader.readLine());

			student.add(num);
		}

		for (int i = 1; i <= 30; i++) {
			if (!student.contains(i)) {
				System.out.println(i);
			}
		}
	}
}
