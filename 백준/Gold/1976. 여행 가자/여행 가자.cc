#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>

using namespace ::std;

// 결국 목적지로의 도달할 수 있는가? 같은 그룹에 속하는가?

int find_root(vector<int> &group, int index)
{
    if (group[index] == index)
    {
        return group[index];
    }
    else
    {
        return group[index] = find_root(group, group[index]);
    }
}

void merge_group(vector<int> &group, int i, int j)
{
    int parent_i = find_root(group, i);
    int parent_j = find_root(group, j);

    if (parent_i == parent_j)
    {
        return;
    }

    if (parent_i <= parent_j)
    {
        group[parent_j] = parent_i;
    }
    else
    {
        group[parent_i] = parent_j;
    }
}

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; // 도시의 수, 200 이하
    int m; // 여행 계획에 속한 도시들의 수, 1000 이하
    int input;

    cin >> n >> m;
    vector<vector<int>> graph(n + 1, vector<int>(n + 1, 0));
    vector<int> order(m + 1);
    vector<int> group(201);

    for (int i = 0; i < 201; i++)
    {
        group[i] = i;
    }

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            cin >> input;
            if (input == 1)
            {
                graph[i][j] = 1;
                graph[j][i] = 1;
                merge_group(group, i, j);
            }
        }
    }

    for (int i = 1; i <= m; i++)
    {
        cin >> order[i];
    }

    for (int i = 2; i <= m; i++)
    {
        if (group[order[i - 1]] != group[order[i]])
        {
            cout << "NO" << '\n';
            return 0;
        }
    }

    cout << "YES" << '\n';
    return 0;
}
