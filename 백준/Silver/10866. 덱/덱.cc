#include <iostream>
#include <algorithm>
#include <deque>
#include <vector>

using namespace ::std;

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    deque<int> deque;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        string cmd;
        int num;
        cin >> cmd;
        if (cmd == "push_front")
        {
            cin >> num;
            deque.push_front(num);
        }
        else if (cmd == "push_back")
        {
            cin >> num;
            deque.push_back(num);
        }
        else if (cmd == "pop_front")
        {
            if (deque.empty())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << deque.front() << '\n';
                deque.pop_front();
            }
        }
        else if (cmd == "pop_back")
        {
            if (deque.empty())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << deque.back() << '\n';
                deque.pop_back();
            }
        }
        else if (cmd == "size")
        {
            cout << deque.size() << '\n';
        }
        else if (cmd == "empty")
        {
            cout << deque.empty() << '\n';
        }
        else if (cmd == "front")
        {
            if (deque.empty())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << deque.front() << '\n';
            }
        }
        else if (cmd == "back")
        {
            if (deque.empty())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << deque.back() << '\n';
            }
        }
    }
}