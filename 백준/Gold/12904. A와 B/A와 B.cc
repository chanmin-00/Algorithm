#include <iostream>
#include <algorithm>
#include <string>

using namespace::std;

int aOrB(string str1, string str2);

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	string str1, str2;
	int result;

	cin >> str1 >> str2;

	while (true) {
		if (str1.compare(str2) == 0) {
			result = 1;
			break;
		}
		else if (str1.length() >= str2.length()) {
			result = 0;
			break;
		}
		if (str2[str2.length() - 1] == 'A') {
			str2 = str2.substr(0, str2.length() - 1);
		}
		else {
			str2 = str2.substr(0, str2.length() - 1);
			reverse(str2.begin(), str2.end());
		}
	}

	cout << result << endl;
}

