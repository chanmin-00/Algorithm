#include <iostream>
#include <algorithm>

using namespace::std;

int arr[100001];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;

	cin >> n;

	for (int i = 1; i <= n; i++) {
		arr[i] = i;
	}

	arr[0] = 0;
	for (int i = 0; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (j > n / j) {
				break;
			}
			
			if ((i + j * j) < 100001 && arr[i + j * j] > arr[i] + 1) {
				arr[i + j * j] = arr[i] + 1;
			}
		}
	}

	cout << arr[n] << "\n";

}