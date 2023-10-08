#include <iostream>
#include <algorithm>

using namespace::std;

int matrix[2188][2188];
int minus_one, zero, one;
int what_is_num(int x, int y, int len) {
	
	for (int i = x; i < x + len; i++) {
		for (int j = y; j < y + len; j++) {
			if (matrix[i][j] != matrix[x][y]) {
				return  1780;
			}
		}
	}
	return matrix[x][y];
}

void same_number_paper(int x, int y, int len) {
		int flag;
		flag = what_is_num(x, y, len);
		if (flag == -1) {
			minus_one++;
		}
		else if (flag == 0) {
			zero++;
		}
		else if (flag == 1) {
			one++;
		}
		else {
			same_number_paper(x, y, len / 3);
			same_number_paper(x + len / 3, y, len /3);
			same_number_paper(x + len / 3 + len/ 3, y, len / 3);
			same_number_paper(x, y + len / 3, len / 3);
			same_number_paper(x, y + len / 3  + len / 3, len / 3);
			same_number_paper(x + len / 3, y + len / 3, len / 3);
			same_number_paper(x + len / 3 + len / 3, y + len / 3 + len / 3, len / 3);
			same_number_paper(x + len / 3, y+ len / 3+ len / 3, len / 3);
			same_number_paper(x + len / 3+ len / 3, y + len / 3, len / 3);
		}
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n_len;
	cin >> n_len;
	minus_one = 0;
	zero = 0;
	one = 0;
	matrix[0][0] = '0';

	for (int i = 1; i <= n_len; i++) {
		for (int j = 1; j <= n_len; j++) {
			cin >> matrix[i][j];
		}
	}

	same_number_paper(1, 1, n_len);
	cout << minus_one << '\n' << zero << '\n' << one << '\n';
}