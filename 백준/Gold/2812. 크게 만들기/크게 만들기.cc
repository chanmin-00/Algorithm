#include <iostream>
#include <algorithm>
#include <string>
#include <stack>

using namespace::std;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int k;
	string num;

	stack<int> stk; // k개를 지우고 남아있는 숫자 값을 저장할 스택

	cin >> n >> k >> num;
	int count = 0;
	int currentIndex = 0;

	while (count < k && currentIndex < n) {
		
		while (!stk.empty() && stoi(string(1, num[stk.top()])) < stoi(string(1, num[currentIndex]))) {
			stk.pop();
			count++;
			if (count == k)
				break;
		}
		
		stk.push(currentIndex);
		currentIndex++;
	}

	for (int i = currentIndex; i < n; i++) {
		stk.push(i);
	}

	int* result = new int[stk.size()];
	int size = stk.size();

	for (int i = size - 1; i > -1; --i) {
		result[i] = stoi(string(1, num[stk.top()]));
		stk.pop();
	}
	for (int i = 0; i < n - k; i++) {
		cout << result[i];
	}
	cout << "\n";
}
