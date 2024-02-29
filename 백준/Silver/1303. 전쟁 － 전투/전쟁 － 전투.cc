#include <iostream>
#include <algorithm>

using namespace::std;

void B_DFS(int x, int y, int& size);
void W_DFS(int x, int y, int& size);

int arr[102][102] = { 0 };
int W[102][102] = { 0 };
int B[102][102] = { 0 };

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n; // 가로 크기
	int m; // 세로 크기

	int wPower = 0;
	int bPower = 0;

	cin >> n >> m;

	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			char tmp;
			cin >> tmp;

			if (tmp == 'W')
				arr[i][j] = 1;
			else
				arr[i][j] = -1;
		}
	}

	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			if (arr[i][j] == 1 && W[i][j] == 0) {
				int size = 1;
				W_DFS(i, j, size);

				wPower += (size * size);
			}
		}
	}

	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			if (arr[i][j] == -1 && B[i][j] == 0) {
				int size = 1;
				B_DFS(i, j, size);

				bPower += (size * size);
			}
		}
	}

	cout << wPower << " " << bPower << "\n";
}

void W_DFS(int x, int y, int &size) {
	
	W[x][y] = 1;

	if (arr[x - 1][y] == 1 && W[x - 1][y] == 0) { // W가 존재하고 방문하지 않은 경우
		++size;
		W_DFS(x - 1, y, size);
	}
	if (arr[x][y + 1] == 1 && W[x][y + 1] == 0) { // W가 존재하고 방문하지 않은 경우
		++size;
		W_DFS(x, y + 1, size);
	}
	if (arr[x + 1][y] == 1 && W[x + 1][y] == 0) { // W가 존재하고 방문하지 않은 경우
		++size;
		W_DFS(x + 1, y, size);
	}
	if (arr[x][y - 1] == 1 && W[x][y - 1] == 0) { // W가 존재하고 방문하지 않은 경우
		++size;
		W_DFS(x, y - 1, size);
	}
}

void B_DFS(int x, int y, int& size) {

	B[x][y] = 1;

	if (arr[x - 1][y] == -1 && B[x - 1][y] == 0) { // W가 존재하고 방문하지 않은 경우
		++size;
		B_DFS(x - 1, y, size);
	}
	if (arr[x][y + 1] == -1 && B[x][y + 1] == 0) { // W가 존재하고 방문하지 않은 경우
		++size;
		B_DFS(x, y + 1, size);
	}
	if (arr[x + 1][y] == -1 && B[x + 1][y] == 0) { // W가 존재하고 방문하지 않은 경우
		++size;
		B_DFS(x + 1, y, size);
	}
	if (arr[x][y - 1] == -1 && B[x][y - 1] == 0) { // W가 존재하고 방문하지 않은 경우
		++size;
		B_DFS(x, y - 1, size);
	}
}