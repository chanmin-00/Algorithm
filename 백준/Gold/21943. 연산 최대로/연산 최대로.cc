#include <iostream>
#include <algorithm>
#include <queue>
#include <climits>

using namespace::std;

int connect_max = INT_MIN;
int n;
int p;
int q;

int returnMax(int* x, int n, int p, int q);

void backtrack(int *x, int* visited, int depth, int* arr)  {
	if (depth == n) {
		int value = returnMax(x, n, p, q);
		if (value > connect_max) {
			connect_max = value;
		}
		return;
	}

	// 아직 방문하지 않은 요소를 방문
	for (int i = 0; i < n; i++) {
		if (!visited[i]) {
			visited[i] = 1; // 방문 표시
			x[depth] = arr[i]; // 배열에 현재 요소 추가
			backtrack(x, visited, depth + 1, arr); // 재귀 호출
			visited[i] = 0; // 백트래킹: 방문 표시 해제
		}
	}
}


int returnMax(int* oldX, int n, int p, int q) {
	
	int* x = new int[n];

	for (int i = 0; i < n; i++) {
		x[i] = oldX[i];
	}
	int result = 1;
	
	if (n == 1) {
		return x[0];
	}

	if (n == 2) {
		if (p == 1) {
			return x[0] + x[1];
		}
		else {
			return x[0] * x[1];
		}
	}

	// 작은 수들을 더해서 크게 만들기
	int index1;
	int index2;
	int min;
	for (int i = 1; i <= p; i++) {
		index1 = 0;
		index2 = 1;

		min = x[index1] + x[index2];

		for (int j = 1; j < n - 1; j++) {
			if (min > x[j] + x[j + 1]) {
				min = x[j] + x[j + 1];
				index1 = j;
				index2 = j + 1;
			}
		}

		queue<int> que;
		for (int j = 0; j < n; j++) {
			if (j != index1 && j != index2) {
				que.push(x[j]);
				//cout << que.back() << "\n";
			}
			else if (j == index1) {
				que.push(x[index1] + x[index2]);
				//cout << que.back() << "\n";
			}
		}

		delete[] x;
		--n;
		int* newX = new int[n];
		for (int j = 0; j < n; j++) {
			newX[j] = que.front();
			que.pop();
		}

		x = newX;
	}



	for (int i = 0; i < n; i++) {
		result *= x[i];
	}

	return result;
}


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;

	int* arr = new int[n];
	int* x = new int[n];
	int* visited = new int[n];
	
	for (int i = 0; i < n; i++) {
		visited[i] = 0;
	}
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	cin >> p >> q;

	backtrack(x, visited, 0, arr);

	cout << connect_max << "\n";

}