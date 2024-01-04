#include <iostream>
#include <algorithm>
#include <vector>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int sum;

	cin >> n;
	
	vector<int> a(n);
	vector<int> b(n);

	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	for (int i = 0; i < n; i++) {
		cin >> b[i];
	}

	sum = 0;
	sort(a.begin(), a.end(), greater<>());
	sort(b.begin(), b.end());

	for (int i = 0; i < n; i++) {
		sum += a[i] * b[i];
	}

	cout << sum << endl;
}