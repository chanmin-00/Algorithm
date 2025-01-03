#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>

using namespace ::std;

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t;

    cin >> t;

    for (int i = 0; i < t; i++)
    {
        string str;
        stack<char> stk;

        cin >> str;

        for (int j = 0; j < str.size(); j++)
        {
            if (str[j] == '(')
            {
                stk.push(str[j]);
            }
            else if (!stk.empty() && stk.top() == '(' && str[j] == ')')
            {
                stk.pop();
            }
            else
            {
                stk.push(str[j]);
            }
        }

        if (stk.empty())
        {
            cout << "YES" << '\n';
        }
        else
        {
            cout << "NO" << '\n';
        }
    }
}