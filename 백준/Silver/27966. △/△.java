import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(reader.readLine());

		long answer = 0;
		answer += N - 1;

		// (n - 1) C 2
		long tmp = (long)(N - 1) * (long)(N - 2) / 2;
		tmp = tmp * 2;

		answer += tmp;

		System.out.println(answer);

		for (int i = 2; i <= N; i++) {
			System.out.println(1 + " " + i);
		}
	}
}
