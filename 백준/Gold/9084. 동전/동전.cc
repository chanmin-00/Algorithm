#include <iostream>
#include <algorithm>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int t, n, m;

	cin >> t;
	int* result = new int[t];

	int* dp;
	int* input;
	for (int i = 0; i < t; i++) {
		cin >> n;
		dp = new int[10001];
		for (int j = 0; j < 10001; j++) {
			dp[j] = 0;
		}
		input = new int[n];

		dp[0] = 1;
		for (int j = 0; j < n; j++) {
			cin >> input[j];
		}
		cin >> m;
		for (int j = 0; j < n; j++) {
			for (int k = input[j]; k <= m; k++) {
				dp[k] = dp[k] + dp[k - input[j]];
			}
		}
		result[i] = dp[m];
		delete(dp);
		delete(input);
	}
	for (int i = 0; i < t; i++) {
		cout << result[i] << endl;
	}
}