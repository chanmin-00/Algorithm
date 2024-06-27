#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>
#include <map>

using namespace ::std;

// 트라이라는 자료 구조 이용,
struct Node
{
    map<string, Node *> child; // 여러 개의 자식 포인터 연결 가능, map은 내부에서 자동적으로 정렬 -> 사전순으로 출력하기 위함

    void insert(vector<string> &arr, int index)
    {
        if (index == arr.size())
        { // 모든 root의 자식들을 다 채운 경우
            return;
        }

        if (child.find(arr[index]) == child.end()) // 자식 노드에 없는 경우, 새로 삽입
        {
            Node *newNode = new Node;
            child.insert(make_pair(arr[index], newNode));
        }

        child[arr[index]]->insert(arr, index + 1);
    }

    void dfs(int index)
    {
        map<string, Node *>::iterator iter = child.begin();
        if (iter == child.end())
            return;

        for (; iter != child.end(); iter++)
        {
            for (int j = 0; j < index; j++)
            {
                cout << "--";
            }
            cout << iter->first << '\n';
            iter->second->dfs(index + 1);
            delete iter->second;
        }
    }
};

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; // 먹이의 정보 개수, 1부터 1000개까지
    int k; // 로봇 개미 한마리가 보내준 먹이의 정보 개수, 1부터 15까지

    Node root;

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> k;
        vector<string> str(k); // k만큼의 크기 생성, size() 함수는 k로 고정됨
        for (int j = 0; j < k; j++)
        {
            cin >> str[j];
        }
        root.insert(str, 0);
    }
    root.dfs(0);
}