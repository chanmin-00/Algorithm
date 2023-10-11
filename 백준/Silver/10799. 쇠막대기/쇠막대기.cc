#include <iostream>
#include <algorithm>
#include <stack>

using namespace::std;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	
	string input;
	int tmp;
	int result = 0;
	cin >> input;

	stack<int> iron;
	for (int i = 0; i < input.length(); i++) {
		if (input.at(i) == '(') {
			iron.push(0);
		}
		else if (input.at(i) == ')' && iron.top() == 0) {
			iron.pop();
			if (!iron.empty())
				iron.top() += 1;
		}
		else if (input.at(i) == ')' && iron.top() != 0) {
			tmp = iron.top();
			result += (tmp + 1);
			iron.pop();
			if(!iron.empty())
				iron.top() += tmp;
		}
	}
	cout << result << '\n';
}

