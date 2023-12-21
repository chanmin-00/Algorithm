#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int max = INT_MIN;
	int* result_arr;
	int* input_arr;
	int* tmp_arr;

	cin >> n;
	result_arr = new int[n];
	input_arr = new int[n];
	
	for (int i = 0; i < n; i++) {
		cin >> input_arr[i];
	}
	result_arr[0] = input_arr[0];
	for (int i = 1; i < n; i++) {
		result_arr[i] = result_arr[i - 1] + input_arr[i];
		if (result_arr[i] < input_arr[i]) {
			result_arr[i] = input_arr[i];
		}
	}
	for (int i = 0; i < n; i++) {
		if (max < result_arr[i]) {
			max = result_arr[i];
		}
	}

	
	cout << max << endl;
}
