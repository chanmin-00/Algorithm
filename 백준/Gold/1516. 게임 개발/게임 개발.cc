#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>
#include <queue>
#include <cmath>

using namespace ::std;

vector<int> result(501, 0);

void topology_sort(vector<int> &building, vector<vector<int>> &graph, vector<int> &degree)
{
    queue<int> q;

    for (int i = 1; i < building.size(); i++)
    {
        if (degree[i] == 0)
        {
            q.push(i);
            result[i] = building[i];
        }
    }

    while (!q.empty())
    {
        int cur = q.front();
        q.pop();

        for (int i = 1; i < building.size(); i++)
        {
            if (graph[cur][i] > 0)
            {
                degree[i]--;
                result[i] = max(result[i], result[cur] + building[i]);
                if (degree[i] == 0)
                {
                    q.push(i);
                }
            }
        }
    }
}

// 어떤 건물을 짓기 위해서는 다른 건물을 먼저 지어야 할 수 도 있음, 위상 정렬, 대표적인 예로 선수과목 문제
int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; // 건물의 종류 수
    cin >> n;

    int tmp, flag = 0;
    vector<int> building(n + 1, 0);
    vector<vector<int>> graph(n + 1, vector<int>(n + 1, 0));
    vector<int> degree(n + 1, 0);

    for (int i = 0; i < n; i++)
    {
        flag = 0;
        while (1)
        {
            cin >> tmp;
            if (tmp == -1)
            {
                break;
            }

            if (flag == 0)
            {
                building[i + 1] = tmp;
                flag = 1;
            }
            else
            {
                graph[tmp][i + 1] = 1;
                degree[i + 1]++;
            }
        }
    }
    topology_sort(building, graph, degree);

    for (int i = 1; i <= n; i++)
    {
        cout << result[i] << '\n';
    }
}