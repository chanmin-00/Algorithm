#include <iostream>
#include <algorithm>
#include <vector>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int w;
	int max;
	cin >> n;
	vector<int> arr(n);

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr.begin(), arr.end(), greater<>());
	
	max = -1;
	w = 1;
	for (int i = 1; i <= n; i++) {
		w = arr[i-1] * i;
		if (w > max) {
			max = w;
		}
	}
	cout << max << endl;

}