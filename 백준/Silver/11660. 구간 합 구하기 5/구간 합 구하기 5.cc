#include <iostream>
#include <algorithm>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;

	int** nArr = new int* [n + 1];
	int** mArr = new int* [m];

	int** dp = new int* [n + 1];

	for (int i = 0; i <= n; i++) {
		nArr[i] = new int[n + 1];
		dp[i] = new int[n + 1];
	}
	
	for (int i = 0; i < m; i++) {
		mArr[i] = new int[4];
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> nArr[i][j];
		}
	}
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < 4; j++) {
			cin >> mArr[i][j];
		}
	}

	dp[1][1] = nArr[1][1];
	for (int i = 0; i <= n; i++) {
		for (int j = 0; j <= n; j++) {
			if (i == 0 || j == 0)
				dp[i][j] = 0;
			else if (i == 1 && j == 1)
				continue;
			else if (i == 1) // 1 행인 경우
				dp[i][j] = nArr[i][j] + dp[i][j - 1];
			else if (j == 1) // 1 열인 경우
				dp[i][j] = nArr[i][j] + dp[i - 1][j];
			else
				dp[i][j] = (nArr[i][j] + dp[i - 1][j] + dp[i][j - 1]) - (dp[i - 1][j - 1]);
		}
	}
	for (int i = 0; i < m; i++) {
		int result;
		int x1 = mArr[i][0];
		int y1 = mArr[i][1];
		int x2 = mArr[i][2];
		int y2 = mArr[i][3];
		result = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
		cout << result << '\n';
	}
}