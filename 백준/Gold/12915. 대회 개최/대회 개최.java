import java.io.*;
import java.util.*;

// 대회를 열기 위해서는 무조건 쉬운 문제, 중간문제, 어려운 문제로 구성이 되어 있어야 한다.
public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		String[] input = reader.readLine().split(" ");

		int E = Integer.parseInt(input[0]);
		int EM = Integer.parseInt(input[1]);
		int M = Integer.parseInt(input[2]);
		int MH = Integer.parseInt(input[3]);
		int H = Integer.parseInt(input[4]);

		int cnt = 0;

		while (true) {
			int tmpE = E;
			int tmpEM = EM;
			int tmpM = M;
			int tmpMH = MH;
			int tmpH = H;

			// 1. easy
			if (tmpE > 0) {
				tmpE--;
			} else if (tmpEM > 0) {
				tmpEM--;
			} else {
				break;
			}

			// 2. high
			if (tmpH > 0) {
				tmpH--;
			} else if (tmpMH > 0) {
				tmpMH--;
			} else {
				break;
			}

			// 3. Middle
			if (tmpM > 0) {
				tmpM--;
			} else if (tmpEM > 0 && tmpMH > 0) {
				if ((tmpEM + tmpE) > (tmpMH + tmpH)) {
					tmpEM--;
				} else {
					tmpMH--;
				}
			} else if (tmpEM > 0 && tmpMH <= 0) {
				tmpEM--;
			} else if (tmpEM <= 0 && tmpMH > 0) {
				tmpMH--;
			} else {
				break;
			}

			E = tmpE;
			EM = tmpEM;
			M = tmpM;
			MH = tmpMH;
			H = tmpH;

			cnt++;

		}

		System.out.println(cnt);

	}
}
