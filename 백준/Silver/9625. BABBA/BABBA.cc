#include <iostream>
#include <algorithm>
#include <vector>

using namespace ::std;

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int k; // 버튼을 k번 눌렀을 때, A와 B의 개수

    cin >> k;

    int a[46]; // 각 단계마다 a의 개수
    int b[46]; // 각 단계마다 b의 개수

    a[0] = 1;
    b[0] = 0;

    for (int i = 1; i <= k; i++)
    {
        a[i] = a[i - 1];
        b[i] = b[i - 1];
        
        a[i] -= a[i - 1];
        a[i] += b[i - 1];
        b[i] += a[i - 1];
    }

    cout << a[k] << " " << b[k] << '\n';
}
