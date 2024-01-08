#include <iostream>
#include <algorithm>
#include <vector>

using namespace::std;


int n ,s;
int cnt;

void subset_sum(int index, int sum, vector<int>& arr) {
	int sum_tmp;
	
	if (index < n || sum == s) {
		if (sum == s && index == n) {
			cnt++;
			return;
		}
		sum_tmp = sum;
		subset_sum(index + 1, sum + arr[index + 1], arr);
		subset_sum(index + 1, sum_tmp, arr);
	}
}
int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> s;
	vector<int> arr(n + 1);

	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}
	arr[0] = -1000001;
	cnt = 0;

	sort(arr.begin(), arr.end());
	subset_sum(0, 0, arr);

	if (s == 0) {
		cnt -= 1;
	}
	cout << cnt << endl;
}

