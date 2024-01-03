#include <iostream>
#include <algorithm>
#include <vector>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;
	
	vector<int> result(n);
	int** arr = new int* [n + 1];
	int** dp = new int* [n + 1];
	int length = 1;
	for (int i = 1; i <= n; i++) {
		arr[i] = new int[length + 1];
		dp[i] = new int[length + 1];
		length++;
	}
	length = 1;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= length; j++) {
			cin >> arr[i][j];
		}
		length++;
	}
	
	dp[1][1] = arr[1][1]; // dp 배열 초기화

	length = 2;
	for (int i = 2; i <= n; i++) {
		for (int j = 1; j <= length; j++) {
			if (j == 1) {
				dp[i][j] = dp[i - 1][1] + arr[i][1];
				continue;
			}
			else if (j == length){
				dp[i][j] = dp[i - 1][length - 1] + arr[i][length];
				continue;
			}
			else {
				dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
			}
		}
		length++;
	}

	for (int i = 1; i <= n; i++) {
		result[i - 1] = dp[n][i];
	}

	sort(result.begin(), result.end());
	cout << result[n - 1] << endl;
}