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
	int count = 0; // 현재 지운 숫자의 개수를 저장하는 변수
	int currentIndex = 0; // num 문자열에서 현재 가리키고 있는 숫자의 위치를 저장하는 변수
	stack<int> stk; // k개를 지우고 남아있는 숫자의 위치(인덱스)를 저장할 스택

	cin >> n >> k >> num;

	while (count < k && currentIndex < n) { // 지운 개수가 k개 보다 작고 currentIndx가 문자열의 범위를 안 넘을 때까지
		
		// 스택에 저장된 숫자보다 현재 숫자가 더 클 경우 top의 숫자를 제거 후 push
		while (!stk.empty() && stoi(string(1, num[stk.top()])) < stoi(string(1, num[currentIndex]))) {
			stk.pop();
			count++; // 지운 개수를 증가
			if (count == k)
				break;
		}
		
		stk.push(currentIndex);
		currentIndex++;
	}
 
	for (int i = currentIndex; i < n; i++) { // 스택에 저장되지 않은 숫자들 스택에 저장
		stk.push(i);
	}

	int* result = new int[stk.size()];
	int size = stk.size();

	for (int i = size - 1; i > -1; --i) { // 스택에서 값 추출
		result[i] = stoi(string(1, num[stk.top()]));
		stk.pop();
	}
	for (int i = 0; i < n - k; i++) { // n - k 개 만큼 결과 출력
		cout << result[i];
	}
	cout << "\n";
}
