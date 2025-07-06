import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		int max = Integer.parseInt(input[0]); // 최대 공약수
		int min = Integer.parseInt(input[1]); // 최소 공배수

		int num = min / max;

		int sumMin = 1 + num;
		int[] sumMinArr = new int[2];
		sumMinArr[0] = 1;
		sumMinArr[1] = num;

		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {

				int num1 = i;
				int num2 = num / i;

				// 두 수가 최대공약수, 최소공배수를 만드는 수가 되기 위해서는 서로소가 되어야 한다.
				// 서로소가 되기 위해서는 두 수 간에 약수가 없어야 한다. -> 최대공약수가 1이어야 한다.
				// 최대공약수를 구하기 위해서는 유클리드 호제법을 이용할 수 있다.

				if (gcd(num1, num2) == 1) {
					int sum = num1 + num2;

					if (sum < sumMin) {
						sumMin = sum;
						sumMinArr[0] = i;
						sumMinArr[1] = num / i;
					}
				}
			}
		}

		System.out.println(max * sumMinArr[0] + " " + max * sumMinArr[1]);
	}

	// 유클리드 호제법 : 어떤 두 수의 최대공약수는, 큰수에서 작은 수를 뺀값과 작은 수의 최대공약수와 같다.
	// gcd(a, b) == gcd(b, a%b)
	// a를 b로 나누면 몫이 q, 나머지가 r이다.
	// a = bq + r;
	// d가 a와 b의 공약수라면, d도 r의 공약수이다. bq/d + r/d = 0
	// 즉, a와 b의 공약수라면 r과 b의 공약수이다.
	public static int gcd(int num1, int num2) {
		while (num2 != 0) {
			int tmp = num1 % num2; // r
			num1 = num2; // b
			num2 = tmp;  // r
		}
		// r이 0이 되는 순간, 즉 나머지가 없는 순간이 약수가 된다.

		return num1;
	}
}
