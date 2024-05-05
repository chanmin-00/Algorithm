#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace ::std;

int arr[1001]; // arr[i]의 의미 : i번째 과목을 수강하기 위해서 최소 몇개가 필요한가?
int input_arr[1001][1001];

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; // 과목의 수, (1 ≤ N ≤ 1000)
    int m; // 선수 조건의 수 (0 ≤ M ≤ 500000)
    int a; // 입력받는 선수 과목
    int b; // 입력받는 선후 과목

    cin >> n >> m;

    for (int i = 0; i < 1001; i++) // 2차원 배열 초기화
    {
        arr[i] = 1;
        for (int j = 0; j < 1001; j++)
        {
            input_arr[i][j] = 0;
        }
    }

    for (int i = 0; i < m; i++)
    {
        cin >> a >> b; // (1 ≤ A < B ≤ N) A가 B보다 선행
        input_arr[a][b] = 1;
    }

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if (input_arr[i][j] == 1)
            {
                arr[j] = max(arr[j], arr[i] + 1);
            }
        }
    }

    for (int i = 1; i <= n; i++)
    {
        cout << arr[i] << ' ';
    }

    cout << "\n";
}