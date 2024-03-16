#include <iostream>
#include <algorithm>
#include <climits>

using namespace::std;

long long  arr[10001];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n; // 운동 기구의 개수
	long long  max = -1L;

	cin >> n;
	
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + n);

	if (n % 2 == 1) {
		for (int i = 0; i < n / 2; i++) {
			if (max < (arr[i] + arr[n - 2 - i])) {
				max = arr[i] + arr[n - 2 - i];
			}
		}
		if (max < arr[n - 1]) {
			max = arr[n - 1];
		}
	}
	else {
		for (int i = 0; i < n / 2; i++) {
			if (max < arr[i] + arr[n - 1 - i]) {
				max = arr[i] + arr[n - 1 - i];
			}
		}
	}

	cout << max << "\n";
}