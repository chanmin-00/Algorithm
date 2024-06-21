#include <iostream>
#include <algorithm>
#include <vector>

using namespace ::std;

int result[15][15];
int dp[15][15] = {
    0,
};
int people_count(int k, int n);
void init_dp(int k, int n);

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int case_count;
    int k; // k층, 0층부터 존재
    int n; // n호, 1호부터 존재

    cin >> case_count;

    for (int i = 0; i < 15; i++)
    {
        dp[0][i] = i; // dp 배열 초기화, 0층의 i호에는 i명이 삼
    }

    for (int i = 0; i < case_count; i++)
    {
        cin >> k >> n;

        result[k][n] = people_count(k, n);
        cout << result[k][n] << '\n';
        // init_dp(k, n);
    }
}

int people_count(int k, int n)
{
    for (int i = 1; i <= k; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if (dp[i][j] == 0)
            {
                for (int k = 1; k <= j; k++)
                {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
    }

    return dp[k][n];
}

void init_dp(int k, int n)
{
    for (int i = 1; i <= k; k++)
    {
        for (int j = 1; j <= n; j++)
        {
            dp[i][j] = 0;
        }
    }
}
