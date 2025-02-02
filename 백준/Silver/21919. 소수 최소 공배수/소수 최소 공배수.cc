#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace ::std;

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    long long result = 1L;
    vector<long long> arr(1000001);

    for (int i = 0; i < n; i++)
    {
        int num;
        cin >> num;
        int cnt = 0;

        for (int j = 1; j * j <= num; j++)
        {
            if (num % j == 0)
            {
                cnt++;
                if ((num / j) != j)
                {
                    cnt++; // 제곱근까지만 계산하기 때문에 더해줄 필요 있음
                }
            }
        }

        if (cnt == 2)
        {
            arr[num] = 1;
        }
    }

    for (int i = 0; i < 1000001; i++)
    {
        if (arr[i] == 1)
        {
            result *= (long long)i;
        }
    }

    if (result == 1)
    {
        cout << -1 << '\n';
    }
    else
    {
        cout << result << '\n';
    }
}
