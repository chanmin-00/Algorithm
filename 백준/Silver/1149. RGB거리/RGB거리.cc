#include <iostream>
#include <algorithm>
#include <vector>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	vector<int> result(3);
	cin >> n;

	int** arr = new int* [n];
	int** dp = new int* [n];
	for (int i = 0; i < n; i++) {
		arr[i] = new int[3];
		dp[i] = new int[3];
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> arr[i][j];
		}
	}
	dp[0][0] = arr[0][0]; dp[0][1] = arr[0][1]; dp[0][2] = arr[0][2];
	for (int i = 1; i < n; i++) {
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
	}
	result[0] = dp[n - 1][0];
	result[1] = dp[n - 1][1];
	result[2] = dp[n - 1][2];
	sort(result.begin(), result.end());

	cout << result[0] << endl;
}