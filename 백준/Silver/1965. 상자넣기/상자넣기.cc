#include <iostream>
#include <algorithm>

using namespace::std;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int tmp;
	int max = 0;
	cin >> n;

	int* input_arr = new int[n];
	int* max_box = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> input_arr[i];
		max_box[i] = 1;
	}

	int tmp_index;
	int tmp_max;
	for (int i = 1; i < n; i++) {
		tmp_index = -1;
		tmp_max = -1;
		for (int j = i - 1; j >= 0; --j) {
			if (input_arr[j] < input_arr[i] && max_box[j] > tmp_max) {
				tmp_index = j;
				tmp_max = max_box[j];
			}
		}
		max_box[i] = max_box[tmp_index] + 1;
		if (max_box[i] > max_box[max]) {
			max = i;
		}
	}
	
	cout << max_box[max] << endl;
}