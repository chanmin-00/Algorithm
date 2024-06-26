#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>
#include <cstring>
#include <queue>

using namespace ::std;

void toTwo(long long int k);
void dfs(long long int &k, string str, int &start);
void bfs(long long int &k, string str, int &count);

// 4와 7로만 이루어진 수를 좋아함
int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    long long int k;
    int start = 0;
    string str = "";

    cin >> k;

    if (k == 1)
    {
        cout << 4 << '\n';
        return 0;
    }
    if (k == 2)
    {
        cout << 7 << '\n';
        return 0;
    }

    // dfs(k, str, start);
    // bfs(k, str, start);
    toTwo(k + 1); // 패턴 발견하기, K+1의 이진수로 바꾼 후 1은 7, 0은 4로 출력하면 됨
}

void toTwo(long long int k)
{
    string binary = "";
    string result = "";
    int size = 0;

    while (k > 0)
    {
        binary = to_string(k % 2) + binary;
        k /= 2;
    }
    binary = binary.substr(1);

    size = binary.length();
    for (int i = 0; i < size; i++)
    {
        if (binary[i] == '1')
        {
            result += "7";
        }
        else
        {
            result += "4";
        }
    }

    cout << result << '\n';
}

void dfs(long long int &k, string str, int &start)
{
    int newStart = start;
    if (start > k)
        return;

    if (start == k)
    {
        cout << str << '\n';
        return;
    }

    string tmp = str;

    tmp += '4';
    start = newStart * 2 + 1;
    dfs(k, tmp, start);

    tmp = str;
    tmp += '7';
    start = newStart * 2 + 2;
    dfs(k, tmp, start);
}

void bfs(long long int &k, string str, int &count)
{
    queue<long long int> que;
    long long int num;
    que.push(4);
    que.push(7);
    count = count + 2;

    while (!que.empty())
    {
        num = que.front();
        num = num * 10 + 4;
        que.push(num);
        if (++count == k)
        {
            break;
        }

        num = que.front();
        num = num * 10 + 7;
        que.push(num);
        if (++count == k)
        {
            break;
        }

        que.pop();
    }

    cout << num << '\n';
}
