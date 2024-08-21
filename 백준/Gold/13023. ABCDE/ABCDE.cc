#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>
#include <set>

using namespace ::std;

bool result = false;

void dfs(vector<vector<int>> &arr, vector<int> &visited, int num, int count);

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; // 사람의 수
    int m; // 친구 관계의 수
    int num1, num2;
    vector<int> v;

    cin >> n >> m;

    vector<vector<int>> arr(n);

    for (int i = 0; i < m; i++)
    {
        cin >> num1 >> num2;
        arr[num1].push_back(num2);
        arr[num2].push_back(num1);

        if (find(v.begin(), v.end(), num1) == v.end())
        {
            v.push_back(num1);
        }
        if (find(v.begin(), v.end(), num2) == v.end())
        {
            v.push_back(num2);
        }
    }

    for (int i = 0; i < v.size(); i++)
    {
        vector<int> visited(n, 0);
        visited[v[i]] = 1;

        dfs(arr, visited, v[i], 0);

        if (result == true)
        {
            cout << '1' << '\n';
            return 0;
        }

        result = false;
    }

    cout << '0' << '\n';
    return 0;
}

void dfs(vector<vector<int>> &arr, vector<int> &visited, int num, int count)
{
    if (count == 4)
    {
        result = true;
        return;
    }

    for (int i = 0; i < arr[num].size(); i++)
    {
        int next = arr[num][i];
        if (!visited[next])
        {
            visited[next] = 1; // 방문한 것으로 표시
            dfs(arr, visited, next, count + 1);
            visited[next] = 0;
        }
    }
}