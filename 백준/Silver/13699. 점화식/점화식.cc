#include <iostream>
#include <algorithm>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	long n;

	cin >> n;
	long* arr = new long[n+1];
	
	arr[0] = 1;
	for (int i = 1; i < n+1; i++) {
		arr[i] = 0;
		for (int j = 0; j < i; j++) {
			arr[i] += arr[j] * arr[i - 1 - j];
		}
	}
	cout << arr[n] << endl;
}