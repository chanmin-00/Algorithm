#include <iostream>
#include <algorithm>
#include <vector>

using namespace::std;

void dfs(int n, int m, int count, vector<int>& arr, vector<int>& tmp);

bool check[100] = { false };

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;

	vector<int> arr(n);
	vector<int> tmp(n);
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		tmp[i] = 0;
	}

	sort(arr.begin(), arr.end());

	dfs(n, m, 0, arr, tmp);
}

void dfs(int n, int m, int count, vector<int> &arr, vector<int> &result) {
	if (count == m) {
		for (int i = 0; i < m; i++) {
			cout << result[i] << " ";
		}
		cout << "\n";
		return;
	}
	int before = 0;
	for (int i = 0; i < n; i++) {
		if (before != arr[i] && !check[i]) {
			result[count] = arr[i];
			before = arr[i]; // 반복문 내에서만 유효
			check[i] = true;
			dfs(n, m, count + 1, arr, result);
			check[i] = false;
		}
	}
}
