#include <iostream>
#include <algorithm>
#include <vector>

using namespace ::std;

long long int dp[91];

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    long long int n; // n번째 피보나치 수를 구하기

    cin >> n;

    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++)
    {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    cout << dp[n] << '\n';
}
