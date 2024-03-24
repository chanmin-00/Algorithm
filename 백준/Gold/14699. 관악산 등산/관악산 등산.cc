#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace::std;

/*
* 쉼터에 도착하면 그 쉼터와 직접 연결된 더 높은 쉼터로 향하는 길들 중 하나를 골라서 그 길을 따라 이동
*/

int arr[5001][5001];
int result[5001];
int dfs(int index, int n);

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n; // 쉼터의 수
	int m; // 두 쉼터 사이를 연결하는 길의 수
	int num1, num2; // 입력받는 쉼터 번호

	cin >> n >> m;

	vector<int> height(n + 1);
	for (int i = 1; i <= n; i++) {
		cin >> height[i];
	}

	fill(arr[0], arr[5001], 0); // 2차원 배열 초기화
	for (int i = 0; i < m; i++) {
		cin >> num1 >> num2;
		arr[num1][num2] = height[num2] - height[num1];
		arr[num2][num1] = height[num1] - height[num2];
	}
	fill(result, result + 5001, 1);

	for (int i = 1; i <= n; i++) {
		dfs(i, n);
	}

	for (int i = 1; i <= n; i++) {
		cout << result[i] << "\n";
	}

}

int dfs(int index, int n) {

	if (result[index] != 1) {
		return result[index];
	}

	for (int i = 1; i <= n; i++) {
		if (arr[index][i] <= 0) {
			continue;
		}
		else {
			result[index] = max(result[index], dfs(i, n) + 1);
		}
	}

	return result[index];
}