#include <iostream>
#include <algorithm>
#include <vector>

using namespace ::std;

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;                       // 연결된 전깃줄의 개수
    vector<pair<int, int>> elec; // 전깃줄 위치 배열
    int idx1, idx2;
    int max_count = 0;

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> idx1 >> idx2;

        elec.push_back(make_pair(idx1, idx2));
    }

    sort(elec.begin(), elec.end());

    vector<int> dp(n, 1); // dp[i] : i번째 전깃줄을 포함했을 때 최대 전깃줄 개수

    for (int i = 0; i < n; i++) // 나보다 아래쪽에 있는 전깃줄과 비교, 겹치지 않는 것들만 비교
    {
        for (int j = 0; j < i; j++)
        {
            if (elec[i].second > elec[j].second)
            {
                dp[i] = max(dp[i], dp[j] + 1);
                if (max_count < dp[i])
                {
                    max_count = dp[i];
                }
            }
        }
    }

    cout << n - max_count << "\n";
}
