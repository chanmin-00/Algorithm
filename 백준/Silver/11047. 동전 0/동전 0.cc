#include <iostream>
#include <algorithm>
#include <vector>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, k;
	int sum = 0;
	int count = 0;

	cin >> n >> k;
	vector<int> arr(n);
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr.begin(), arr.end(), greater<>());

	for (int i = 0; i < n; i++) {
		sum += arr[i];
		count = count + 1;
		if (sum > k) {
			sum -= arr[i];
			count -= 1;
		}
		else if (sum == k) {
			break;
		}
		else {
			i--;
		}
	}
	cout << count << endl;
}