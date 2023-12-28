#include <iostream>
#include <algorithm>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;

	long long int* arr = new long long int[n+1];
	arr[0] = 0;
	arr[1] = 1;
	for (int i = 2; i < n + 1; i++) {
		arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
	}
	cout << arr[n]  << endl;
}