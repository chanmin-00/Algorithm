#include <iostream>
#include <algorithm>
#include <vector>

using namespace ::std;

// 모든 휴게소 간의 거리가 최대한 균등해야지 최대값이 최소가 됨을 활용

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; // 현재 휴게소의 개수
    int m; // 더 지으려고 하는 휴게소의 개수
    int l; // 고속도로의 길이

    cin >> n >> m >> l;
    int *input_arr = new int[n + 2];

    for (int i = 0; i < n; i++)
    {
        cin >> input_arr[i];
    }

    input_arr[n] = 0;
    input_arr[n + 1] = l;

    sort(input_arr, input_arr + n + 2);

    int start = 1;
    int end = l - 1;
    int mid = 0;
    int ans = 9999;

    while (start <= end)
    {
        mid = (start + end) / 2;
        int count = 0; // 현재의 휴게소 개수, m개를 만족해야 함

        for (int i = 1; i < n + 2; i++)
        {
            int len = (input_arr[i] - input_arr[i - 1]);
            int tmp = len / mid;

            if (tmp > 0)
            {
                if (len % mid == 0)
                { // 마지막 휴게소와 겹쳤다는 의미
                    count += tmp - 1;
                }
                else
                {
                    count += tmp;
                }
            }
        }

        if (count > m)
        {
            start = mid + 1; // 간격 넓혀주기
        }
        else
        {
            end = mid - 1; // 간격 좁혀주기
        }
    }
    cout << start << "\n";
}