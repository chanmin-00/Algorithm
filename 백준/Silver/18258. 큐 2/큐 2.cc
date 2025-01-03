#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace ::std;

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int N;         // 명령의 수
    string input;  // 명령
    int num_input; // 숫자 입력

    queue<int> que; // 큐

    cin >> N;

    for (int i = 0; i < N; i++)
    {
        cin >> input;

        if (input == "push")
        {
            cin >> num_input;
            que.push(num_input);
        }
        else if (input == "pop")
        {
            if (que.empty() == 1)
            {
                cout << -1 << '\n';
            }
            else
            {
                int result = que.front();
                que.pop();
                cout << result << '\n';
            }
        }
        else if (input == "size")
        {
            int size = que.size();
            cout << size << '\n';
        }
        else if (input == "empty")
        {
            int empty = que.empty();
            cout << empty << '\n';
        }
        else if (input == "front")
        {
            if (que.empty() == 1)
            {
                cout << -1 << '\n';
            }
            else
            {
                int result = que.front();
                cout << result << '\n';
            }
        }
        else if (input == "back")
        {
            if (que.empty() == 1)
            {
                cout << -1 << '\n';
            }
            else
            {
                int result = que.back();
                cout << result << '\n';
            }
        }
    }
}
