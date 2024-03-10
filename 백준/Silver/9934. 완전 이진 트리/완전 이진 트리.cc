#include <iostream>
#include <algorithm>
#include <cmath>

using namespace::std;

void dfs(int k, int index, int& count);

int arr[1025];
int tree[1025];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int k;
	int count;
	int powNum;

	cin >> k;
	powNum = pow(2, k) - 1;
	count = 1;
	
	for (int i = 1; i <= powNum; i++) {
		cin >> arr[i];
	}

	dfs(powNum, 1, count);
	
	for (int i = 1; i <= powNum; i++) {
		cout << tree[i] << " ";
		switch (i) {
		case 1: cout << "\n"; break;
		case 3: cout << "\n"; break;
		case 7: cout << "\n"; break;
		case 15: cout << "\n"; break;
		case 31: cout << "\n"; break;
		case 63: cout << "\n"; break;
		case 127: cout << "\n"; break;
		case 255: cout << "\n"; break;
		case 511: cout << "\n"; break;
		case 1023: cout << "\n"; break;
		}
	}
}

void dfs(int powNum, int index, int& count) {
	

	if (index <= powNum) {
		dfs(powNum, index * 2, count);
		tree[index] = arr[count++];
		dfs(powNum, index * 2 + 1, count);
	}
}
