#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace ::std;

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; // 트리의 정점의 개수
    cin >> n;

    vector<int> adj[100001];             // 인접리스트
    vector<pair<int, int>> line(100001); // 간선 정보 저장

    for (int i = 1; i < n; i++)
    {
        int a, b;

        cin >> a >> b;

        adj[a].push_back(b);
        adj[b].push_back(a);

        line[i] = make_pair(a, b);
    }

    int q; // 질의의 개수
    cin >> q;

    for (int i = 0; i < q; i++)
    {
        int t, k;
        cin >> t >> k;

        if (t == 1)
        {
            if (adj[k].size() == 1)
            {
                cout << "no" << '\n';
            }
            else
            {
                cout << "yes" << '\n';
            }
        }
        else if (t == 2)
        {

            cout << "yes" << '\n';
        }
    }
}
