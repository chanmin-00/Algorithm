#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int* result;
	stack<int> stk;
	vector<string> printResult(200000);

	cin >> n;
	result = new int[n];
	
	for (int i = 0; i < n; i++) {
		cin >> result[i];
	}

	int count = 0; // 입력 배열 인덱스
	int index = 1; // 입력값
	int vectorIndex = 0; // 출력 벡터 인덱스
	while (count < n) {
		if ((!stk.empty()) && stk.top() == result[count]) {
			stk.pop();
			count++;
			printResult.at(vectorIndex) = "-";
			vectorIndex++;
		}
		else {
			if (index == n + 1) {
				cout << "NO" << "\n";
				return 0;
			}
			if ((!stk.empty()) && result[count] < stk.top()) {
				cout << "NO" << "\n";
				return 0;
			}
			stk.push(index);
			index++;
			printResult.at(vectorIndex) = "+";
			vectorIndex++;
		}
	}

	for (int i = 0; i < vectorIndex; i++) {
		cout << printResult[i] << "\n";
	}
	
	return 0;
}