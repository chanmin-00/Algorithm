#include <iostream>
#include <algorithm>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int* arr;
	int* dp;
	int max;


	cin >> n;
	arr = new int[n];
	dp = new int[n];


	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	dp[0] = arr[0];
	max = dp[0];

	int tmp_max;
	for (int i = 1; i < n; i++) {
		tmp_max = -1;
		for (int j = i - 1; j > -1; j--) {
			if (arr[i] > arr[j]) {
				dp[i] = dp[j] + arr[i];
				if (dp[i] > tmp_max) {
					tmp_max = dp[i];
				}
			}
		}
		if (tmp_max != -1)
			dp[i] = tmp_max;
		else {
			dp[i] = arr[i];
		}
		if (dp[i] > max) {
			max = dp[i];
		}
	}

	cout << max << endl;
}