/*
* 태그로 들어온것은 큐로 출력
* 단어로 들어온것은 스택으로 출력
*/

#include <iostream>
#include <algorithm>
#include <stack>
#include <queue>
#include <cstring>
#include <string>


using namespace std;

void clear_que(queue<char>& que_tmp) {
	while (!que_tmp.empty()) {
		cout << que_tmp.front();
		que_tmp.pop();
	}
}

void clear_stack(stack<char>& stk_tmp) {
	while (!stk_tmp.empty()) {
		cout << stk_tmp.top();
		stk_tmp.pop();
	}
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	string str;
	int str_len;
	int queue_flag = 0;

	stack<char> stk_str;
	queue<char> que_str;

	getline(cin, str);

	str_len = str.length();
	for (int i = 0; i < str_len; i++) {
		if (str[i] == '<' && queue_flag == 0) {
			if (!stk_str.empty())
				clear_stack(stk_str);
			queue_flag = 1;
			que_str.push(str[i]);
		}
		else if (str[i] == '>') {
			que_str.push(str[i]);
			queue_flag = 0;
			clear_que(que_str);
		}
		else if (queue_flag) {
			que_str.push(str[i]);
		}
		else if ((!stk_str.empty()) && (str[i] == ' ')) {
			clear_stack(stk_str);
			if (str[i] == ' ')
				cout << " ";
		}
		else {
			if (str[i] == ' ')
				cout << " ";
			else
				stk_str.push(str[i]);
		}
	}
	if (!stk_str.empty())
		clear_stack(stk_str);
	cout << "\n";

}
