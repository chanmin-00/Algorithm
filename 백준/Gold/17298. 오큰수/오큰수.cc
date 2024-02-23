#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, input;

	cin >> n;
	stack<int> stk;
	vector<int> arr(1000000);
	vector<int> NGE(1000000);

	for (int i = 0; i < n; i++) {
		cin >> input;
			
		arr.at(i) = input;
		NGE.at(i) = -1;
	}

	for (int i = 0; i < n; i++) {

		while (!stk.empty() && arr[stk.top()] < arr[i]) {
			NGE.at(stk.top()) = arr[i];
			stk.pop();
		}
		stk.push(i);
	}

	for (int i = 0; i < n; i++) {
		cout << NGE.at(i) << " ";
	}

	cout << endl;
}