#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>
#include <map>

using namespace ::std;

bool comp(string a, string b) // 문자열 길이 순으로 정렬하기 위한 비교 함수
{
    if (a.length() != b.length())
    {
        return a.length() < b.length();
    }
    else
    {
        return a < b;
    }
}

struct Trie
{
    map<string, Trie *> child;

    void insert(vector<string> &arr, int index, bool &tf) // 재귀적으 자기 자신에게 insert
    {
        if (index == arr.size())
        {
            tf = true;
            return;
        }

        for (int i = 0; i < arr[index].length(); i++)
        {
            if (child.find(arr[index].substr(0, i + 1)) != child.end())
            {
                tf = false;
                return;
            }
        }
        Trie *newTrie = new Trie;
        child.insert(make_pair(arr[index], newTrie));

        insert(arr, index + 1, tf); // 키값을 인덱스로 하여 insert
    }
};

// 한 번호가 다른 번호이 접두어인 경우가 없어야 함
int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t; // 테스트 케이스의 개수
    int n; // 전화번호의 수

    cin >> t;
    for (int i = 0; i < t; i++)
    {
        cin >> n;
        vector<string> str(n);
        bool tf = false;
        Trie *root = new Trie; // 사용하기 위해서는 초기화 필수!!!

        for (int j = 0; j < n; j++)
        {
            cin >> str[j];
        }
        sort(str.begin(), str.end(), comp); // 정렬 필요
        /*
        for (int i = 0; i < str.size(); i++)
        {
            cout << str[i] << '\n';
        }
        */

        root->insert(str, 0, tf);
        if (tf == true)
        {
            cout << "YES" << '\n';
        }
        else
        {
            cout << "NO" << '\n';
        }
    }
}