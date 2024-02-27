#include <iostream>
#include <algorithm>

using namespace::std;
#define INF 0x3f3f3f3f;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int arr[51][51] = { 0 };
	string inputStr;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> inputStr;
		for (int j = 0; j < n; j++) {
			if (inputStr.at(j) == 'Y') {
				arr[i][j] = 1;
			}
			else {
				arr[i][j] = INF;
			}
		}
	}

	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] > arr[i][k] + arr[k][j]) {
					arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
	}

	int max = 0;
	for (int i = 0; i < n; i++) {
		int cnt = 0;
		for (int j = 0; j < n; j++) {
			if (i == j)
				continue;
			if (arr[i][j] <= 2) {
				++cnt;
			}
		}
		if (max < cnt) {
			max = cnt;
		}
	}

	cout << max << endl;
}