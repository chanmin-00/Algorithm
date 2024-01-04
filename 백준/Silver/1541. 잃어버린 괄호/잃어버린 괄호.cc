#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	
	string str;
	vector<string> sum(50);

	cin >> str;

	int start_index = 0;
	int count = 0;

	for (int i = 0; i < str.length();i++) { // "-"를 기준으로 파싱
		if (str[i] == '-') {
			sum[count] = str.substr(start_index, i - start_index);
			start_index = i + 1;
			count++;
		}
	}
	sum[count] = str.substr(start_index);
	count++;

	int result = 0;
	for (int i = 0; i < count; i++) {
		str = sum[i];
		start_index = 0;
		int tmp_sum = 0;
		for (int j = 0; j < str.length(); j++) {
			if (str[j] == '+') {
				tmp_sum += stoi(str.substr(start_index, j - start_index));
				start_index = j + 1;
			}
			if (j == str.length() - 1) {
				tmp_sum += stoi(str.substr(start_index));
			}
		}
		if (i == 0)
			result += tmp_sum;
		else
			result -= tmp_sum;
	}
	cout << result << endl;
}