#include <iostream>
#include <algorithm>
#include <vector>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	vector<int> decide_max_candy(3);

	cin >> n >> m;

	int** arr = new int* [n + 1];
	int** candy = new int* [n + 1]; // 사탕 최대 개수 저장하는 DP 배열
	for (int i = 1; i <= n; i++) {
		arr[i] = new int[m + 1];
		candy[i] = new int[m + 1];
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> arr[i][j];
		}
	}

	candy[1][1] = arr[1][1]; // DP 배열 초기화

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (i ==1 && j == 1){
				continue;
			}
			else if (i == 1 && j != 1) { // 이미 값이 정해진 경우
				candy[i][j] = arr[i][j] + candy[i][j - 1];
				continue;
			}
			else if (i != 1 && j == 1)
			{
				candy[i][j] = arr[i][j] + candy[i - 1][j];
				continue;
			}
			decide_max_candy[0] = candy[i - 1][j];
			decide_max_candy[1] = candy[i][j - 1];
			decide_max_candy[2] = candy[i - 1][j - 1];
			sort(decide_max_candy.begin(), decide_max_candy.end());
			candy[i][j] = arr[i][j] + decide_max_candy[2];
		}
	}
	cout << candy[n][m] << endl;

}