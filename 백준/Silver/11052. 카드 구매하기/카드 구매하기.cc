#include <iostream>
#include <algorithm>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int result;
	cin >> n;

	int* arr = new int[n + 1];
	int* dp = new int[n + 1];
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}

	result = 1;
	dp[1] = arr[1];
	for (int i = 2; i <= n; i++) {
		dp[i] = arr[i];
		for (int j = 1; j < i; j++) {
			dp[i] = max(dp[i - j] + dp[j], dp[i]);
		}
		if (result < dp[i])
			result = dp[i];
	}
	cout << result << endl;
}