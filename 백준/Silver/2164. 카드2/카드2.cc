#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace ::std;

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    queue<int> que;
    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        que.push(i);
    }

    while (que.size() > 1)
    {
        que.pop();
        int front = que.front();
        que.pop();
        que.push(front);
    }

    cout << que.front() << '\n';
}