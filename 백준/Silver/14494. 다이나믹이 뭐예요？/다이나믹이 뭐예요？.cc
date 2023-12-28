#include <iostream>
#include <algorithm>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;

	long long** arr = new long long*[n + 1];
	for (int i = 0; i < n+1; i++) {
		arr[i] = new long long[m + 1];
	}
	arr[1][1] = 1;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (i == 1 && j == 1)
				continue;
			if (i == 1) {
				arr[i][j] = arr[i][j - 1];
				continue;
			}
			if (j == 1) {
				arr[i][j] = arr[i - 1][j];
				continue;
			}
			arr[i][j] = (arr[i - 1][j] + arr[i][j - 1] + arr[i - 1][j - 1]) % 1000000007;
		}
	}
	cout << arr[n][m] << endl;

}