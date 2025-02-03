#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace ::std;

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int arr[52][52];
    fill(&arr[0][0], &arr[0][0] + 52 * 52, -2);

    int plus[52][52];
    fill(&plus[0][0], &plus[0][0] + 52 * 52, 0);

    int r; // 행
    int c; // 열
    int t; // 초, T초가 지난 후

    int air1;          // 위쪽 공기 청정기 행 위치
    int air2;          // 아래쪽 공기 청정기 행 위치
    int air_visit = 0; // air1 방문 여부

    int result = 0;

    cin >> r >> c >> t;

    for (int i = 1; i <= r; i++)
    {
        for (int j = 1; j <= c; j++)
        {
            cin >> arr[i][j];
            if (arr[i][j] == -1 && air_visit == 0)
            {
                air1 = i;
                air2 = i + 1;
                air_visit = 1;
            }
        }
    }

    for (int i = 0; i < t; i++)
    {
        // 1. 미세먼지 확산
        for (int j = 1; j <= r; j++)
        {
            for (int k = 1; k <= c; k++)
            {
                if (arr[j][k] == 0) // 미세먼지가 없는 경우 그냥 지나가기
                {
                    continue;
                }
                else // 미세먼지가 있는 경우 확산하기
                {
                    int cnt = 0;                                    // 확산 개수
                    if (arr[j][k - 1] != -2 && arr[j][k - 1] != -1) // 왼쪽이 벽이 아니고, 공기청정기가 없는 경우
                    {
                        plus[j][k - 1] += (arr[j][k] / 5);
                        cnt++;
                    }
                    if (arr[j - 1][k] != -2 && arr[j - 1][k] != -1) // 위쪽이 벽이 아니고, 공기청정기가 없는 경우
                    {
                        plus[j - 1][k] += (arr[j][k] / 5);
                        cnt++;
                    }
                    if (arr[j][k + 1] != -2 && arr[j][k + 1] != -1) // 오른쪽이 벽이 아니고, 공기청정기가 없는 경우
                    {
                        plus[j][k + 1] += (arr[j][k] / 5);
                        cnt++;
                    }
                    if (arr[j + 1][k] != -2 && arr[j + 1][k] != -1) // 위쪽이 벽이 아니고, 공기청정기가 없는 경우
                    {
                        plus[j + 1][k] += (arr[j][k] / 5);
                        cnt++;
                    }

                    arr[j][k] -= (cnt * (arr[j][k] / 5));
                }
            }
        }

        for (int i = 1; i <= r; i++)
        {
            for (int j = 1; j <= c; j++)
            {
                arr[i][j] += plus[i][j];
                plus[i][j] = 0;
            }
        }

        // 2. 위쪽 공기청정기 공기 확산, 공기청정기로 들어간 미세먼지는 0이 됨
        int old = 0;
        int tmp;
        for (int j = 2; j <= c; j++)
        {
            tmp = arr[air1][j];
            arr[air1][j] = old; // 뒤에 있던 값 넣기
            old = tmp;
        }
        for (int j = air1 - 1; j >= 1; j--)
        {
            tmp = arr[j][c];
            arr[j][c] = old;
            old = tmp;
        }
        for (int j = c - 1; j >= 1; j--)
        {
            tmp = arr[1][j];
            arr[1][j] = old;
            old = tmp;
        }
        for (int j = 2; j < air1; j++)
        {
            tmp = arr[j][1];
            arr[j][1] = old;
            old = tmp;
        }

        // 2. 아래쪽 공기청정기 공기 확산, 공기청정기로 들어간 미세먼지는 0이 됨
        old = 0;

        for (int j = 2; j <= c; j++)
        {
            tmp = arr[air2][j];
            arr[air2][j] = old; // 뒤에 있던 값 넣기
            old = tmp;
        }
        for (int j = air2 + 1; j <= r; j++)
        {
            tmp = arr[j][c];
            arr[j][c] = old;
            old = tmp;
        }
        for (int j = c - 1; j >= 1; j--)
        {
            tmp = arr[r][j];
            arr[r][j] = old;
            old = tmp;
        }
        for (int j = r - 1; j > air2; j--)
        {
            tmp = arr[j][1];
            arr[j][1] = old;
            old = tmp;
        }
    }

    for (int i = 1; i <= r; i++)
    {
        for (int j = 1; j <= c; j++)
        {
            if (arr[i][j] != -1)
            {
                result += arr[i][j];
            }
            // cout << arr[i][j] << ' ';
        }
        //cout << '\n';
    }

    cout << result << '\n';
}
