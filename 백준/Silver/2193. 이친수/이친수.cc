#include <iostream>
#include <algorithm>

using namespace::std;

long arr[100];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	arr[1] = 1;
	arr[2] = 1;

	int n;

	cin >> n;

	if (n == 1 || n == 2) {
		cout << arr[n] << "\n";
		return 0;
	}
	
	for (int i = 3; i <= n; i++) {
		arr[i] = arr[i - 2] + arr[i - 1];
	}
	cout << arr[n] << "\n";
}