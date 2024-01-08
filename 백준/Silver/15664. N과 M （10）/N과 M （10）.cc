#include <iostream>
#include <algorithm>
#include <vector>

using namespace::std;

void subset(int count, int index, int n, int m, vector<int>& n_arr);
int m_arr[8];
bool check[8] = { false };

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;

	vector<int> n_arr(n);

	for (int i = 0; i < n; i++) {
		cin >> n_arr[i];
	}

	sort(n_arr.begin(), n_arr.end());
	subset(0, 0, n, m, n_arr);
}

void subset(int count, int index, int n, int m, vector<int> &n_arr) {
	
	if (count == m) {
		for (int i = 0; i < m; i++) {
			cout << m_arr[i] << " ";
		}
		cout << endl;
		return;
	}
	int before;
	for (int i = index; i < n; i++) {
		if (before != n_arr[i] && !check[i]){
			m_arr[count] = n_arr[i];
			before = m_arr[count];
			check[i] = true;
			subset(count + 1, i + 1, n, m, n_arr);
			check[i] = false;
		}
	}
}