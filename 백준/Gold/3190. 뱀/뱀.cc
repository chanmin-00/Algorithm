#include <iostream>
#include <algorithm>
#include <queue>
#include <cstring>

using namespace::std;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, k, l;
	int x, y;
	int num;
	char c;
	queue<pair<int, int>> location;
	queue<pair<int, char>> direction;

	cin >> n;
	int** arr = new int* [n + 1];
	for (int i = 0; i < n + 1; i++) {
		arr[i] = new int[n + 1];
		memset(arr[i], 0, (n + 1) * sizeof(int));
	}

	cin >> k;
	for (int i = 0; i < k; i++) {
		cin >> x >> y;
		arr[x][y] = 1; // 사과가 들어있는 경우 1로 표시
	}

	cin >> l;
	for (int i = 0; i < l; i++) {
		cin >> num >> c;
		direction.push({ num, c });
	}
	location.push({1, 1});

	int time = 0;
	int currentX, currentY;
	int directionPoint = 0;
	while (true) {
		time++;
		currentX = location.back().first;
		currentY = location.back().second;

		
		if (directionPoint == 0) { // 동쪽
			currentY = currentY + 1;
		}
		else if (directionPoint == 1) { // 남쪽
			currentX = currentX + 1;
		}
		else if (directionPoint == 2) { // 서쪽
			currentY = currentY - 1;
		}
		else { // 북쪽
			currentX = currentX - 1;
		}

		if (currentX > n || currentY > n || currentX < 1 || currentY < 1) // 벽에 부딪힌 경우
			break;
		if (arr[currentX][currentY] == 2) // 자신의 몸에 닿은 경우
			break;

		if (arr[currentX][currentY] == 1) { // 사과를 먹은 경우
			location.push({ currentX, currentY });
		}
		else {
			location.push({ currentX, currentY });
			arr[location.front().first][location.front().second] = 0; // 뱀이 위치하지 않는 경우
			location.pop();
		}
		arr[currentX][currentY] = 2; // 현재 뱀이 위치하고 있으면 2를 설정

		if (direction.front().first == time && !direction.empty()) { // 이동 후 방향 설정
			if (direction.front().second == 'D') {
				directionPoint = (directionPoint + 1) % 4;
			}
			else if (direction.front().second == 'L') {
				directionPoint = (directionPoint + 3) % 4;
			}
			direction.pop();
		}
	}

	cout << time << endl;
	return 0;
}