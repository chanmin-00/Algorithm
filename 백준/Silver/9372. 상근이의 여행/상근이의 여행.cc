#include <iostream>
#include <algorithm>

using namespace::std;

int arr[1001];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int t; // 테스트 케이스의 개수
	int n; // 국가의 수
	int m; // 비행기의 종류

	cin >> t;

	for (int i = 0; i < t; i++) {
		cin >> n >> m;
		for (int j = 0; j < m; j++) {
			int a, b;
			cin >> a >> b;
		}
		arr[i] = n - 1;
	}

	for (int i = 0; i < t; i++) {
		cout << arr[i] << '\n';
	}

}
