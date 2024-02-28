#include <iostream>
#include <algorithm>

using namespace::std;

void DFS(int x, int y, int& size, int& maxSize);

int arr[102][102] = { 0 }; // 음식물 쓰레기 좌표 배열
int visited[102][102] = { 0 }; // 음식물 쓰레기 좌표 배열
int n; // 통로의 세로 길이
int m; // 통로의 가로 길이

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int k; // 음식물 쓰레기 개수

	cin >> n >> m >> k;
	
	for (int i = 0; i < k; i++) {
		int r; // 좌표 x
		int c; // 좌표 y

		cin >> r >> c;
		arr[r][c] = 1;
	}
	int maxSize = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (arr[i][j] == 1 && visited[i][j] == 0) {
				int size = 1;
				DFS(i, j, size, maxSize);
			}
		}
	}

	cout << maxSize << endl;

}

void DFS(int x, int y, int& size, int& maxSize) {
	visited[x][y] = 1;

	if (arr[x - 1][y] == 1 && visited[x - 1][y] == 0) { // 음식물 쓰레기가 존재하고 방문하지 않은 경우
		size++;
		if (size > maxSize) {
			maxSize = size;
		}
		DFS(x - 1, y, size, maxSize);
	}
	if (arr[x][y + 1] == 1 && visited[x][y + 1] == 0) {
		size++;
		if (size > maxSize) {
			maxSize = size;
		}
		DFS(x, y + 1, size, maxSize);
	}
	if (arr[x + 1][y] == 1 && visited[x + 1][y] == 0) {
		size++;
		if (size > maxSize) {
			maxSize = size;
		}
		DFS(x + 1, y, size, maxSize);
	}
	if (arr[x][y - 1] == 1 && visited[x][y - 1] == 0) {
		size++;
		if (size > maxSize) {
			maxSize = size;
		}
		DFS(x, y - 1, size, maxSize);
	}
}

