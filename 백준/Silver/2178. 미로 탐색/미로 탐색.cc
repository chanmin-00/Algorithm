#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>
#include <queue>

using namespace ::std;

// 최단 경로로 가기 위해서는 DFS가 아니라 BFS로 풀어야 함. DFS로 풀게 되면 최단 경로로 안 갈 수 있음
int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    string tmp;

    cin >> n >> m;

    vector<vector<int>> arr(n + 1, vector<int>(m + 1, 0));     // n+1과 m+1 크기만큼 초기화
    vector<vector<int>> visited(n + 1, vector<int>(m + 1, 0)); // n+1과 m+1 크기만큼 초기화
    queue<pair<int, int>> que;
    int cnt = 0; // 배열 상에서의 현재 위치

    for (int i = 0; i < n; i++)
    {
        cin >> tmp;
        for (int j = 0; j < m; j++)
        {
            arr[i][j] = tmp[j] - '0';
        }
    }

    que.push({0, 0});
    visited[0][0] = 1;

    int dx[4] = {0, 1, -1, 0}; // 우, 하, 상, 좌
    int dy[4] = {1, 0, 0, -1};

    while (!que.empty())
    {
        int x = que.front().first;
        int y = que.front().second;
        que.pop();

        for (int i = 0; i < 4; i++)
        { // 우, 하, 상, 좌 4방향 다 시도, 너비 우선 탐색으로 최단 경로 찾기, 깊이 우선 탐색x
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m && arr[newX][newY] == 1 && visited[newX][newY] == 0)
            {
                que.push({newX, newY});
                visited[newX][newY] = visited[x][y] + 1;
            }
        }
    }

    cout << visited[n - 1][m - 1] << '\n';
}