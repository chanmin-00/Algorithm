#include <iostream>
#include <algorithm>
#include <string.h>
#include <vector>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int result;
	string s;
	cin >> n;

    result = n;
	// 문자열 배열 입력
	vector<string> arr;
	for (int i = 0; i < n; i++) {
		cin >> s;
		arr.push_back(s);
	}

	// 문자열 배열 정렬
	sort(arr.begin(), arr.end());

	// 문자열 포함 여부 찾기
	for (int i = 0; i < n-1;i++) {
		for (int j = i+1; j < n; j++) {
			if (arr[j].find(arr[i]) == 0) {
				result--;
				break;
			}
		}
	}
	cout << result << endl;
}