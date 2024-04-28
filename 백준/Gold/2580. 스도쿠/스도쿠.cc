#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace ::std;

int input[11][11];

bool check(int x, int y, int value);
void dfs(int count);

// 백트래킹으로 풀기
int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cin >> input[i][j];
        }
    }
    dfs(0);
}

void dfs(int count)
{
    if (count == 81)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                cout << input[i][j] << " ";
            }
            cout << "\n";
        }
        exit(0);
    }

    int x = count / 9;
    int y = count % 9;

    if (input[x][y] == 0)
    {
        for (int k = 1; k <= 9; k++)
        {
            if (check(x, y, k))
            {
                input[x][y] = k;
                dfs(count + 1);
                input[x][y] = 0; // 값을 다시 0으로 초기화
            }
        }
    }
    else
    {
        dfs(count + 1); // 현재 칸이 이미 채워져 있으면 다음 칸으로 넘어감
    }
}

bool check(int x, int y, int value)
{
    for (int i = 0; i < 9; i++) // 열 검사
    {
        if (input[x][i] == value && input[x][i] != 0)
        {
            return false;
        }
    }
    for (int i = 0; i < 9; i++) // 행 검사
    {
        if (input[i][y] == value && input[i][y] != 0)
        {
            return false;
        }
    }

    // 같은 정사각형 내 검사
    int startX = x / 3 * 3;
    int startY = y / 3 * 3;

    for (int i = startX; i < startX + 3; i++)
    {
        for (int j = startY; j < startY + 3; j++)
        {
            if (input[i][j] == value && input[i][j] != 0)
            {
                return false;
            }
        }
    }

    return true;
}