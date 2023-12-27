#include <iostream>
#include <algorithm>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	double *max_multi = new double[n];
	double tmp;
	double max = -1;

	for (int i = 0;i < n; i++) {
		cin >> max_multi[i];
		if (max_multi[i] > max) {
			max = max_multi[i];
		}
	}
	for (int i = 1; i < n; i++) {
		tmp = max_multi[i - 1] * max_multi[i];
		if (tmp > max_multi[i - 1]) {
			if (tmp > max_multi[i])
				max_multi[i] = tmp;
		}
		else {
			if (tmp > max_multi[i]) {
				max_multi[i] = tmp;
			}
		}
		if (max_multi[i] > max) {
			max = max_multi[i];
		}
	}

	/*for (int i = 0; i < n; i++) {
		cout << max_multi[i] << " ,";
	}
	*/
	cout << fixed;
	cout.precision(3);
	cout << max << endl;
}