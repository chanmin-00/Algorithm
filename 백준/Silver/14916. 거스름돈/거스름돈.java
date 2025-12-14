import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(reader.readLine());

		// n = 5x + 2y -> 방정식
		int x = 1;
		int result = 0;
		while (5 * x <= n) {
			int tmp = n - 5 * x;
			if (tmp % 2 == 0) {
				result = Math.max(x, result);
			}
			x++;
		}

		int resultX = result;
		int resultY = (n - 5 * resultX) / 2;

		if (resultX == 0) {
			if (n % 2 == 0) {
				System.out.println(n / 2);
			}
			else {
				System.out.println(-1);
			}
		}
		else {
			System.out.println(resultX + resultY);
		}

	}
}
