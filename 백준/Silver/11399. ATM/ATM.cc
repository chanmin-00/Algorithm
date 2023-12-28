#include <iostream>
#include <algorithm>
#include <vector>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int min_sum = 0;
	cin >> n;
	
	vector<int> pi(n);
	for (int i = 0; i < n; i++) {
		cin >> pi[i];
	}

	sort(pi.begin(), pi.end());
	min_sum = pi[0];

	for (int i = 1; i < n; i++) {
		pi[i] += pi[i - 1];
		min_sum += pi[i];
	}

	cout << min_sum << endl;
	
}