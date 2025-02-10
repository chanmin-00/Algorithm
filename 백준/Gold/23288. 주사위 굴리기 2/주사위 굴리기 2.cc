#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace ::std;

int arr[21][21];

int n; // 지도의 세로 크기
int m; // 지도의 가로 크기
int k; // 이동하는 횟수

int *jusawi_init();
void to_east(int *jusawi, int &x, int &y, int &where);
void dfs(vector<vector<int>> &visited, int &num, int x, int y, int &cnt);
void go(int &where, int *jusawi, int &x, int &y);

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int result = 0; // 결과
    int x = 1;      // 현재 x 위치
    int y = 1;      // 현재 y 위치
    int where = 0;  // 현재 이동방향 동쪽 0, 남쪽 1, 서쪽 2, 북쪽 3

    cin >> n >> m >> k;

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            cin >> arr[i][j];
        }
    }

    int *jusawi = jusawi_init();

    for (int i = 0; i < k; i++)
    {
        vector<vector<int>> visited(21, vector<int>(21, 0));

        go(where, jusawi, x, y);

        // cout << "where :" << where << '\n';
        // cout << x << "," << y << '\n';

        dfs(visited, arr[x][y], x, y, result); // 이동한 후 점수 획득

        if (jusawi[0] > arr[x][y]) // 시계 방향으로 방향 틀기
        {
            where = (where + 1) % 4;
        }
        else if (jusawi[0] < arr[x][y]) // 반시계 방향으로 방향 틀기
        {
            where = (where + 3) % 4;
        }
        else
        {
            where = where;
        }
    }

    cout << result << '\n';
}

void dfs(vector<vector<int>> &visited, int &num, int x, int y, int &cnt)
{
    if (visited[x][y] != 0) // 이미 방문한 경우
    {
        return;
    }

    visited[x][y] = 1;

    // 연속해서 이동 가능하다는것만 확인!!
    if (arr[x][y] == num) // 방문을 하지 않은 경우, 점수 획득 가능한지 체크
    {
        cnt += num;

        // cout << x << "," << y << '\n';
        // cout << "num : " << num << '\n';

        if (x > 1)
        {
            dfs(visited, num, x - 1, y, cnt); // 1칸 북쪽 이동
        }
        if (y > 1)
        {
            dfs(visited, num, x, y - 1, cnt); // 1칸 서쪽 이동
        }
        if (x < n)
        {
            dfs(visited, num, x + 1, y, cnt); // 1칸 남쪽 이동
        }
        if (y < m)
        {
            dfs(visited, num, x, y + 1, cnt); // 1칸 동쪽 이동
        }
    }
}

// 주사위 정보 초기화
int *jusawi_init()
{
    int *jusawi = new int[6];
    jusawi[0] = 6; // 주사위 아랫면
    jusawi[1] = 1; // 주사위 윗면
    jusawi[2] = 5; // 주사위 전면
    jusawi[3] = 2; // 주사위 후면
    jusawi[4] = 4; // 주사위 서쪽
    jusawi[5] = 3; // 주사위 동쪽

    return jusawi;
}

// 주사위 동쪽 이동
void to_east(int *jusawi, int &x, int &y, int &where)
{
    where = 0;
    int tmp = jusawi[0];
    jusawi[0] = jusawi[5];
    jusawi[5] = jusawi[1];
    jusawi[1] = jusawi[4];
    jusawi[4] = tmp;

    y++;
}

void to_west(int *jusawi, int &x, int &y, int &where)
{
    where = 2;
    int tmp = jusawi[0];
    jusawi[0] = jusawi[4];
    jusawi[4] = jusawi[1];
    jusawi[1] = jusawi[5];
    jusawi[5] = tmp;

    y--;
}

void to_south(int *jusawi, int &x, int &y, int &where)
{
    where = 1;
    int tmp = jusawi[0];
    jusawi[0] = jusawi[2]; // 주사위 아랫면
    jusawi[2] = jusawi[1]; // 주사위 전면
    jusawi[1] = jusawi[3]; // 주사위 윗면
    jusawi[3] = tmp;       // 주사위 후면

    x++;
}

void to_norst(int *jusawi, int &x, int &y, int &where)
{
    where = 3;

    int tmp = jusawi[0];

    jusawi[0] = jusawi[3]; // 주사위 아랫면
    jusawi[3] = jusawi[1]; // 주사위 후면
    jusawi[1] = jusawi[2]; // 주사위 윗면
    jusawi[2] = tmp;       // 주사위 전면

    x--;
}

void go(int &where, int *jusawi, int &x, int &y)
{
    if (where == 0) // 동쪽
    {
        if (y < m)
        {
            to_east(jusawi, x, y, where);
        }
        else
        {
            to_west(jusawi, x, y, where);
        }
    }
    else if (where == 1) // 남쪽
    {
        if (x < n)
        {
            to_south(jusawi, x, y, where);
        }
        else
        {
            to_norst(jusawi, x, y, where);
        }
    }
    else if (where == 2) // 서쪽
    {
        if (y > 1)
        {
            to_west(jusawi, x, y, where);
        }
        else
        {
            to_east(jusawi, x, y, where);
        }
    }
    else // 북쪽
    {
        if (x > 1)
        {
            to_norst(jusawi, x, y, where);
        }
        else
        {
            to_south(jusawi, x, y, where);
        }
    }
}
