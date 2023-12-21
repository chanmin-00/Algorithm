#include <iostream>
#include <algorithm>
#include <vector>
#include <limits>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	long int n;
	long int min = INTMAX_MAX;
	long int sum = 0;
	long int result;
	
	cin >> n;
	vector<int> rank(n);

	for (int i = 0; i < n; i++) {
		cin >> rank[i];
	}
	sort(rank.begin(), rank.end());

	for (int i = 0; i < n; i++) {
		sum += abs(rank[i] - (i + 1));
	}
	cout << sum << endl;
	
}