import java.io.*;
import java.util.*;

// N번째 글자까지 가기 위해서 S(K)에 대한 값을 알아내야 한다.
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(reader.readLine());
		
		int len = 10;
		int middle = 4;

		while (true) {
			if (len >= N) {
				break;
			}
			
			middle++;
			len = len + len + middle;
		}
		int left = (len - middle) / 2;

		// 여기서 도출된 index까지만 구하면 된다.
		// n번째 값이 왼쪽, 중앙, 오른쪽 중 어느 위치에 있는지 파악하면 된다.
		String result = divide(N, left, middle);
		System.out.println(result);
	}

	// left: S(k-1)의 길이
	// middie : 중간 moo 수열의 길이
	public static String divide(int N, int left, int middle) {
		if (left == 1) {
			if (N != 1) {
				return "o";
			}
			else {
				return "m";
			}
		}

		if (N <= left) {
			int newLeft = (left - (middle - 1)) / 2;
			int newMiddle = middle - 1;
			return divide(N, newLeft, newMiddle);
		}
		else if (N <= left + middle) { // 중간에 위치하면 바로 값을 도출해낼 수 있다.
			int tmp = N - left;
			if (tmp == 1) {
				return "m";
			}
			else {
				return "o";
			}
		}
		else {
			int newLeft = (left - (middle - 1)) / 2;
			int newMiddle = middle - 1;
			int newN = N - (left + middle);
			return divide(newN, newLeft, newMiddle);
		}
	}
}
