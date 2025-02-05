#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace ::std;

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string num;

    cin >> num;

    // 1. 최댓값 구하기
    int m = 0;       // k를 발견하기 전까지 m의 개수
    string max = ""; // 최댓값 문자열 정보

    for (int i = 0; i < num.size(); i++)
    {
        if (num[i] == 'K')
        {
            if (m != 0)
            {
                max = max.substr(0, max.length() - m);
            }

            max += "5";
            for (int j = 0; j < m; j++)
            {
                max += "0";
            }

            m = 0;
        }
        else
        {
            max += "1";
            m++;
        }
    }

    // 2. 최소값 구하기
    m = 0;
    string min = "";
    for (int i = 0; i < num.size(); i++)
    {
        if (num[i] == 'M')
        {
            if (m == 0)
            {
                min += "1";
                m++;
            }
            else
            {
                min += "0";
                m++;
            }
        }
        else
        {
            min += "5";
            m = 0;
        }
    }

    cout << max << "\n";
    cout << min << "\n";
}
