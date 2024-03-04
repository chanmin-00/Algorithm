#include <iostream>
#include <algorithm>
#include <climits>

using namespace::std;

int arr[3000001];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;

	cin >> n;

	fill(arr, arr + 3000001, 1000000);
	arr[1] = 0;

	for (int i = 1; i <= n; i++) {
		if (arr[i * 3] > (arr[i] + 1)) {
			arr[i * 3] = arr[i] + 1;
		}
		if (arr[i * 2] > (arr[i] + 1)) {
			arr[i * 2] = arr[i] + 1;
		}
		if (arr[i + 1] > (arr[i] + 1)) {
			arr[i + 1] = arr[i] + 1;
		}

		//cout << arr[i + 1] << arr[i * 2] << arr[i * 3] << ",";
		//cout << endl;
	}

	cout << arr[n] << "\n";
	
}

