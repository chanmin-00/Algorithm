#include <iostream>
#include <algorithm>

using namespace::std;

int cost[100001];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n; // 유제품의 수
	int totalCost = 0;
	bool exitFlag = false;

	cin >> n;
	
	for (int i = 1; i <= n; i++) {
		cin >> cost[i];
	}

	sort(cost + 1, cost + n + 1, greater<>());

	int index = 1;
	while (true) {
		
		if (exitFlag)
			break;
		
		for (int i = 0; i < 2; i++) {
			totalCost += cost[index];
			index++;
			if (index > n) {
				exitFlag = true;
				break;
			}
		}
		
		index++;
	}

	cout << totalCost << "\n";
}