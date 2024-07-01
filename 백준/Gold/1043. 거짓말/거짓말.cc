#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>
#include <map>
#include <set>

using namespace ::std;

// 진실을 아는 사람의 type과 모르는 사람의 type으로 나뉘어짐, union-find로 풀기
// 계속해서 그룹을 합쳐 나가기, 최종적으로 같은 그룹에 진실을 아는 사람이 한명이라도 있으면 과장하면 안됨
// 모르겠어서 다른 사람 코드 참고

// 그룹과 연결된 최상위 그룹 찾기
int find_root(vector<int> &group, int people)
{
    if (group[people] == people)
    {
        return group[people];
    }
    else
    {
        return group[people] = find_root(group, group[people]); // 부모의 부모 찾기
    }
}

void merge_group(vector<int> &group, int child1, int child2)
{
    int root1 = find_root(group, child1);
    int root2 = find_root(group, child2);

    if (root1 != root2) // 그룹이 다를 경우 그룹 합치기,
    {
        if (root1 <= root2) // 그룹 번호가 더 작은 쪽이 부모가 되도록 통일
        {
            // cout << child1 << " : " << group[child1] << ", " << child2 << " : " << group[child2] << '\n';
            // 진실을 알고 있는 사람이 포함되어있으면 무조건 0이 되게 만들기 위해서
            group[root2] = root1;
        }
        else
        {
            group[root1] = root2;
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;                 // 사람의 수
    int m;                 // 파티의 수
    int known;             // 진실을 아는 사람의 수, 진실을 들은 사람은 진실을 아는 사람으로 계속해서 추가가 됨
    vector<int> group(52); // 자신이 어는 그룹에 속해 있는지를 나타내기 위해서
    vector<int> party[51]; // 파티 참여자 정보
    int tmp;
    int result;

    cin >> n >> m;
    cin >> known;

    vector<int> party_count(m + 1);

    for (int i = 1; i <= n; i++)
    {
        group[i] = i; // 그룹 자체를 자기 자신으로 초기화
    }
    for (int i = 1; i <= known; i++)
    {
        cin >> tmp;
        group[tmp] = 0; // 진실을 아는 사람의 그룹을 0으로 초기화
    }

    for (int i = 1; i <= m; i++)
    {
        cin >> tmp;
        int input;
        int root;

        party_count[i] = tmp;
        for (int j = 1; j <= tmp; j++)
        {
            cin >> input;

            if (j == 1)
            {
                root = input;
                party[i].push_back(input);
                continue;
            }

            party[i].push_back(input);       // 파티 참여 정보 저장
            merge_group(group, root, input); // 루트 노드와 같은 그룹으로 합치기
        }
    }

    result = m;
    for (int i = 1; i <= m; i++)
    {
        for (int j = 0; j < party_count[i]; j++)
        {
            if (find_root(group, party[i][j]) == 0)
            {
                // cout << i << ", " << j << '\n';
                result--;
                break;
            }
        }
    }

    cout << result << '\n';
}