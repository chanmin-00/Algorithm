import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		String str = reader.readLine();

		TreeSet<String> treeSet = new TreeSet<>();

		for (int i = 0; i < str.length(); i++) {
			String tmp = str.substring(i);

			treeSet.add(tmp);
		}

		for (String result : treeSet) {
			System.out.println(result);
		}

	}
}
