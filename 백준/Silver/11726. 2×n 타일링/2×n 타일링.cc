#include <iostream>
#include <algorithm>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;

	int* arr = new int[n + 1];
	arr[1] = 1;


	if (n > 1) {
		for (int i = 2; i <= n; i++) {
			if (i == 2)
				arr[i] = 2;
			else {
				arr[i] = (arr[i - 2] + arr[i - 1]) % 10007;
			}
		}
	}

	cout << arr[n] << endl;
}