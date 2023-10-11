#include <iostream>
#include <algorithm>
#include <cstring>

using namespace::std;

int arr[65][65];

int same_number(int x, int y, int len) {
	for (int i = x; i < x + len; i++) {
		for (int j = y; j < y + len; j++) {
			if (arr[x][y] != arr[i][j])
				return 0;
		}
	}
	return 1;
}

void quard_tree(int x, int y, int len) {
	if (!same_number(x, y, len)) {
		cout << "(";
		quard_tree(x, y, len / 2);
		quard_tree(x, y + len / 2, len / 2);
		quard_tree(x + len / 2, y, len / 2);
		quard_tree(x + len / 2, y + len / 2, len / 2);
		cout << ")";
	}
	else {
		cout << arr[x][y];
	}
}


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int len;
	string tmp;
	cin >> len;
	for (int i = 1; i <= len; i++) {
		cin >> tmp;
		for (int j = 1; j <= len; j++) {
			if (tmp.at(j - 1) == '0')
				arr[i][j] = 0;
			else
				arr[i][j] = 1;
		}
	}
	quard_tree(1, 1, len);
}