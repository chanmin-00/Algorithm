#include <iostream>
#include <algorithm>
#include <vector>

using namespace ::std;

void dfs(int a, int b, int c, int *arr);
int a_size, b_size, c_size; // 각 용량
int visited[201][201][201] = {
    0,
}; // 방문 여부

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int a = 0;
    int b = 0;
    int c = 0;

    cin >> a_size >> b_size >> c_size;
    c = c_size;

    int arr[c_size + 1] = {
        0,
    }; // c의 용량을 저장할 배열

    dfs(a, b, c, arr);

    for (int i = 0; i <= c_size; i++)
    {
        if (arr[i] == 1)
        {
            cout << i << " ";
        }
    }
}

void dfs(int a, int b, int c, int *arr)
{
    int move = 0; // 옮겨야 할 용량

    if (visited[a][b][c] == 1)
    {
        return;
    }

    if (a == 0 && c >= 0 && c <= c_size) // a가 비어있을 때 c의 용량 저장
    {
        arr[c] = 1;
    }

    visited[a][b][c] = 1;

    if (a > 0 && b < b_size) // a에서 b로 옮기기
    {
        move = min(a, b_size - b); // b_size - b : b에 남은 용량
        dfs(a - move, b + move, c, arr);
    }

    if (a > 0 && c < c_size) // a에서 c로 옮기기
    {
        move = min(a, c_size - c);
        dfs(a - move, b, c + move, arr);
    }

    if (b > 0 && a < a_size) // b에서 a로 옮기기
    {
        move = min(b, a_size - a);
        dfs(a + move, b - move, c, arr);
    }

    if (b > 0 && c < c_size) // b에서 c로 옮기기
    {
        move = min(b, c_size - c);
        dfs(a, b - move, c + move, arr);
    }

    if (c > 0 && a < a_size) // c에서 a로 옮기기
    {
        move = min(c, a_size - a);
        dfs(a + move, b, c - move, arr);
    }

    if (c > 0 && b < b_size) // c에서 b로 옮기기
    {
        move = min(c, b_size - b);
        dfs(a, b + move, c - move, arr);
    }
}