import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long k;
	static long cnt = 0L;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		k = Long.parseLong(reader.readLine());

		findSameIndex();

		if (k == 1) {
			if (cnt % 2 == 0) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		} else {
			if (cnt % 2 == 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	public static void findSameIndex() {
		if (k <= 2) {
			return;
		}

		long index = 1;

		while (index < k) {
			index *= 2;
		}

		index /= 2;

		if (k % index != 0) {
			k %= index;
		}
		else {
			k = index;
		}


		cnt++;
		findSameIndex();
	}
}
