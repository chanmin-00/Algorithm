#include <iostream>
#include <algorithm>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int sum_count[11];

	for (int i = 0; i < 11; i++) {
		sum_count[i] = 0;
	}
	cin >> n;
	int* input_arr = new int[n+1];
	for (int i = 1; i <= n; i++) {
		cin >> input_arr[i];
	}

	sum_count[1] = 1;
	sum_count[2] = 2;
	sum_count[3] = 4;

	for (int i = 4; i <= 10; i++) {
		int sum = 0;
		for (int j = 1; j <= 3; j++) {
			 sum += sum_count[i - j];
		}
		sum_count[i] = sum;
	}
	for (int i = 1; i <= n; i++) {
		cout << sum_count[input_arr[i]] << endl;
	}
}