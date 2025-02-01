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

    vector<int> adj[100001];
    vector<int> result(100001, 0);

    for (int i = 1; i < n; i++)
    {
        int num1, num2;

        cin >> num1 >> num2;

        adj[num1].push_back(num2);
        adj[num2].push_back(num1);
    }

    int root = 1;
    queue<int> que;
    que.push(root);

    while (!que.empty())
    {
        int parent = que.front();
        que.pop();

        int size = adj[parent].size();

        for (int i = 0; i < size; i++)
        {
            int child = adj[parent][i];
            if (result[child] == 0)
            {
                result[child] = parent;

                que.push(child);
            }
        }
    }

    for (int i = 2; i <= n; i++)
    {
        cout << result[i] << '\n';
    }
}
