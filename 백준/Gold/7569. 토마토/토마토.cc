#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace ::std;

int tomato[101][101][101];
int visited[101][101][101] = {
    0,
};
int date[101][101][101] = {
    0,
};

int h, n, m;
void bfs(queue<vector<int>> que);

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int result = 0;
    queue<vector<int>> que;

    cin >> m >> n >> h;

    for (int i = 0; i < h; i++)
    {
        for (int j = 0; j < n; j++)
        {
            for (int k = 0; k < m; k++)
            {
                cin >> tomato[i][j][k];
                if (tomato[i][j][k] == 1)
                {
                    que.push({i, j, k});
                }
            }
        }
    }
    bfs(que);
}

void bfs(queue<vector<int>> que)
{
    int max = 0;
    int check = 0; // 안 익은 토마토의 개수
    while (!que.empty())
    {

        int oldX = que.front()[0];
        int oldY = que.front()[1];
        int oldZ = que.front()[2];
        que.pop();

        // 왼쪽 확인
        if (oldX - 1 >= 0 && tomato[oldX - 1][oldY][oldZ] == 0 && visited[oldX - 1][oldY][oldZ] == 0)
        {
            que.push({oldX - 1, oldY, oldZ});
            visited[oldX - 1][oldY][oldZ] = 1;
            date[oldX - 1][oldY][oldZ] = date[oldX][oldY][oldZ] + 1;
            tomato[oldX - 1][oldY][oldZ] = 1;
            if (max < date[oldX - 1][oldY][oldZ])
            {
                max = date[oldX - 1][oldY][oldZ];
            }
        }
        // 오른쪽 확인
        if (oldX + 1 < h && tomato[oldX + 1][oldY][oldZ] == 0 && visited[oldX + 1][oldY][oldZ] == 0)
        {
            que.push({oldX + 1, oldY, oldZ});
            visited[oldX + 1][oldY][oldZ] = 1;
            date[oldX + 1][oldY][oldZ] = date[oldX][oldY][oldZ] + 1;
            tomato[oldX + 1][oldY][oldZ] = 1;
            if (max < date[oldX + 1][oldY][oldZ])
            {
                max = date[oldX + 1][oldY][oldZ];
            }
        }
        // 위 확인
        if (oldY - 1 >= 0 && tomato[oldX][oldY - 1][oldZ] == 0 && visited[oldX][oldY - 1][oldZ] == 0)
        {
            que.push({oldX, oldY - 1, oldZ});
            visited[oldX][oldY - 1][oldZ] = 1;
            date[oldX][oldY - 1][oldZ] = date[oldX][oldY][oldZ] + 1;
            tomato[oldX][oldY - 1][oldZ] = 1;
            if (max < date[oldX][oldY - 1][oldZ])
            {
                max = date[oldX][oldY - 1][oldZ];
            }
        }
        // 아래 확인
        if (oldY + 1 < n && tomato[oldX][oldY + 1][oldZ] == 0 && visited[oldX][oldY + 1][oldZ] == 0)
        {
            que.push({oldX, oldY + 1, oldZ});
            visited[oldX][oldY + 1][oldZ] = 1;
            date[oldX][oldY + 1][oldZ] = date[oldX][oldY][oldZ] + 1;
            tomato[oldX][oldY + 1][oldZ] = 1;
            if (max < date[oldX][oldY + 1][oldZ])
            {
                max = date[oldX][oldY + 1][oldZ];
            }
        }
        // 앞 확인
        if (oldZ - 1 >= 0 && tomato[oldX][oldY][oldZ - 1] == 0 && visited[oldX][oldY][oldZ - 1] == 0)
        {
            que.push({oldX, oldY, oldZ - 1});
            visited[oldX][oldY][oldZ - 1] = 1;
            date[oldX][oldY][oldZ - 1] = date[oldX][oldY][oldZ] + 1;
            tomato[oldX][oldY][oldZ - 1] = 1;
            if (max < date[oldX][oldY][oldZ - 1])
            {
                max = date[oldX][oldY][oldZ - 1];
            }
        }
        // 뒤 확인
        if (oldZ + 1 < m && tomato[oldX][oldY][oldZ + 1] == 0 && visited[oldX][oldY][oldZ + 1] == 0)
        {
            que.push({oldX, oldY, oldZ + 1});
            visited[oldX][oldY][oldZ + 1] = 1;
            date[oldX][oldY][oldZ + 1] = date[oldX][oldY][oldZ] + 1;
            tomato[oldX][oldY][oldZ + 1] = 1;
            if (max < date[oldX][oldY][oldZ + 1])
            {
                max = date[oldX][oldY][oldZ + 1];
            }
        }
    }

    for (int i = 0; i < h; i++)
    {
        for (int j = 0; j < n; j++)
        {
            for (int k = 0; k < m; k++)
            {
                if (tomato[i][j][k] == 0)
                {
                    check++;
                }
            }
        }
    }

    if (check == 0)
    {
        cout << max;
    }
    else
    {
        cout << -1;
    }
}
