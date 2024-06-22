#include <iostream>
#include <vector>

using namespace std;

int alpha[27] = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string A, B;
    cin >> A >> B;

    int len = A.length();
    vector<int> a_number(len);
    vector<int> b_number(len);

    for (int i = 0; i < len; i++)
    {
        a_number[i] = alpha[A[i] - 'A'];
        b_number[i] = alpha[B[i] - 'A'];
    }

    vector<vector<int>> dp(len * 2, vector<int>(len * 2, 0));

    for (int i = 0, index = 0; i < len; i++, index += 2)
    {
        dp[0][index] = a_number[i];
    }
    for (int i = 0, index = 1; i < len; i++, index += 2)
    {
        dp[0][index] = b_number[i];
    }

    for (int i = 1; i < len * 2 - 1; i++)
    {
        for (int j = i; j < len * 2; j++)
        {
            dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 10;
        }
    }

    cout << dp[len * 2 - 2][len * 2 - 2] << dp[len * 2 - 2][len * 2 - 1] << '\n';

    return 0;
}
