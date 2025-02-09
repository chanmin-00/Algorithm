#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace ::std;

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; // 문제의 수
    cin >> n;

    string BR;
    cin >> BR;

    int b_cnt = 0; // 파란색 수 (연속된 같은 색은 하나로 합쳐서 생각)
    int r_cnt = 0; // 빨간색 수

    for (int i = 1; i < BR.length(); i++)
    {
        if (BR[i - 1] != BR[i])
        {
            if (BR[i - 1] == 'B')
            {
                b_cnt++;
            }
            else
            {
                r_cnt++;
            }
        }

        if (i + 1 == BR.length())
        {
            if (BR[i] == 'B')
            {
                b_cnt++;
            }
            else
            {
                r_cnt++;
            }
        }
    }

    if (b_cnt >= r_cnt)
    {
        cout << r_cnt + 1 << '\n';
    }
    else
    {
        cout << b_cnt + 1 << '\n';
    }

    // cout << "b : " << b_cnt << ", r : " << r_cnt << '\n';
}

