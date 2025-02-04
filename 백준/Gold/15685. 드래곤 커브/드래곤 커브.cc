#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace ::std;

void dragon(int x, int y, int d, int g);
int arr[101][101];

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; // 드래곤 커브의 개수
    int result = 0;
    cin >> n;

    fill(&arr[0][0], &arr[0][0] + 100 * 100, 0);

    int x; // 드래곤 커브의 시작점 x, x축으로 생각
    int y; // 드래곤 커브의 시작점 y, y축으로 생각
    int d; // 드래곤 커브의 시작 방향
    int g; // 드래곤 커브 세대

    for (int i = 0; i < n; i++)
    {
        cin >> x >> y >> d >> g;

        dragon(x, y, d, g);
    }

    for (int i = 0; i < 100; i++)
    {
        for (int j = 0; j < 100; j++)
        {
            if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i][j + 1] && arr[i + 1][j + 1])
            {
                result++;
            }
        }
    }
    cout << result << '\n';
}

void dragon(int x, int y, int d, int g)
{
    vector<int> direct;
    int old_x, old_y;

    direct.push_back(d);
    arr[y][x] = 1;

    if (d == 0)
    {
        arr[y][x + 1] = 1;
        old_x = x + 1;
        old_y = y;
    }
    else if (d == 1)
    {
        arr[y - 1][x] = 1;
        old_x = x;
        old_y = y - 1;
    }
    else if (d == 2)
    {
        arr[y][x - 1] = 1;
        old_x = x - 1;
        old_y = y;
    }
    else if (d == 3)
    {
        arr[y + 1][x] = 1;
        old_x = x;
        old_y = y + 1;
    }

    // cout << old_x << ',' << old_y << '\n';

    for (int i = 0; i < g; i++)
    {
        int size = direct.size();
        for (int j = size - 1; j >= 0; j--)
        {
            if (direct[j] == 0)
            {
                direct.push_back(1); // y쪽으로 증가하는 방향으로 변경

                old_x = old_x;
                old_y = old_y - 1;
                arr[old_y][old_x] = 1;
            }
            else if (direct[j] == 1)
            {
                direct.push_back(2); // x쪽으로 증가하는 방향으로 변경

                old_x = old_x - 1;
                old_y = old_y;
                arr[old_y][old_x] = 1;
            }
            else if (direct[j] == 2) // y쪽으로 감소하는 방향으로 변경
            {
                direct.push_back(3);

                old_x = old_x;
                old_y = old_y + 1;
                arr[old_y][old_x] = 1;
            }
            else if (direct[j] == 3)
            {
                direct.push_back(0);

                old_x = old_x + 1;
                old_y = old_y;
                arr[old_y][old_x] = 1;
            }
            // cout << old_x << ',' << old_y << '\n';
        }
    }
}
