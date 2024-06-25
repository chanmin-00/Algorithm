#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>

using namespace ::std;

long long int fibo[50];
void result(long long int num);

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    // 피보나치 배열 초기화
    fibo[0] = 0;
    fibo[1] = 1;
    for (int i = 2; i < 50; i++)
    {
        fibo[i] = fibo[i - 1] + fibo[i - 2];
    }

    int t;
    long long int num;
    cin >> t;

    for (int i = 0; i < t; i++)
    {
        cin >> num;
        result(num);
        cout << '\n';
    }
}

void result(long long int num)
{
    int index;
    int count = 0;
    vector<long long int> result;
    while (num != 0)
    {
        for (int i = 0; i < 50; i++)
        {
            if (num < fibo[i])
            {
                index = i - 1;
                break;
            }
        }
        result.push_back(fibo[index]);
        count++;
        num -= fibo[index];
    }
    sort(result.begin(), result.end());

    for (int i = 0; i < count; i++)
    {
        cout << result[i] << " ";
    }
}

