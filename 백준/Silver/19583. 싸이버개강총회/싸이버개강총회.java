import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		String[] startTimeArr = input[0].split(":");
		String[] endTimeArr = input[1].split(":");
		String[] streamingEndTimeArr = input[2].split(":");

		int startTime = Integer.parseInt(startTimeArr[0]) * 3600 + Integer.parseInt(startTimeArr[1]) * 60;
		int endTime = Integer.parseInt(endTimeArr[0]) * 3600 + Integer.parseInt(endTimeArr[1]) * 60;
		int streamingEndTime =
			Integer.parseInt(streamingEndTimeArr[0]) * 3600 + Integer.parseInt(streamingEndTimeArr[1]) * 60;

		int result = 0;

		HashMap<String, List<Integer>> chatMap = new HashMap<>();

		while (true) {
			String inputStr = reader.readLine();

			if (inputStr == null) {
				break;
			}

			input = inputStr.split(" ");

			String[] chatTimeArr = input[0].split(":");

			String nickName = input[1];
			int chatTime = Integer.parseInt(chatTimeArr[0]) * 3600 + Integer.parseInt(chatTimeArr[1]) * 60;

			if (chatMap.containsKey(nickName)) {
				List<Integer> timeList = chatMap.get(nickName);
				timeList.add(chatTime);

				chatMap.put(nickName, timeList);
			} else {
				List<Integer> timeList = new ArrayList<>();
				timeList.add(chatTime);

				chatMap.put(nickName, timeList);
			}
		}

		Set<String> keySet = chatMap.keySet();

		for (String key : keySet) {
			List<Integer> timeList = chatMap.get(key);
			boolean startTimeCheck = false;
			boolean endTimeCheck = false;

			for (int i = 0; i < timeList.size(); i++) {
				if (timeList.get(i) <= startTime) {
					startTimeCheck = true;
				}
				if (timeList.get(i) >= endTime && timeList.get(i) <= streamingEndTime) {
					endTimeCheck = true;
				}
			}

			if (startTimeCheck && endTimeCheck) {
				result++;
			}
		}

		System.out.print(result);

	}

}
