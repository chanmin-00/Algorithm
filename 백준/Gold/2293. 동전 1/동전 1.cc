#include <iostream>
#include <algorithm>
#include <vector>

using namespace::std;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, k;
	cin >> n >> k;
	vector<int> arr(n);
	
	int* dp = new int[100001];

	for (int i = 0; i < 100001; i++) {
		dp[i] = 0;
	}

	dp[0] = 1;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr.begin(), arr.end());

	for (int i = 0; i < n; i++) {
		for(int j = arr[i];j<100001;j++)
			dp[j] = dp[j] + dp[j - arr[i]];
	}
	
	cout << dp[k] << endl;
}