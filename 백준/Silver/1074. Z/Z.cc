#include <iostream>
#include <algorithm>

using namespace::std;

int result;
int r, c;
// 분할 정복 기법
// 메모리 초과로 인해 배열을 생성하지 않고 푸는 방법 생각
void zet(int x, int y, int len) {
	if (len > 2) {
		if ((x <= r && r < x + len / 2) && (y <= c && c < y + len / 2))
			zet(x, y, len / 2);
		else if ((x <= r && r < x + len / 2) && (y + len / 2 <= c && c < y + len)) {
			result += len / 2 * len / 2;
			zet(x, y + len / 2, len / 2);
		}
		else if ((x + len / 2 <= r && r < x + len) && (y <= c && c < y + len / 2)) {
			result += len / 2 * len / 2 * 2;
			zet(x + len / 2, y, len / 2);
		}
		else if ((x + len / 2 <= r && r < x + len) && (y + len / 2 <= c && c < y + len)) {
			result += len / 2 * len / 2 * 3;
			zet(x + len / 2, y + len / 2, len / 2);
		}
	}
	else if (len <= 2) {
		if (x == r && y == c) {
			result += 1;
			cout << result-1 << '\n';
			return;
		}
		else if (x == r && y + 1 == c) {
			result += 2;
			cout << result-1 << '\n';
			return;
		}
		else if (x + 1== r && y == c) {
			result += 3;
			cout << result-1 << '\n';
			return;
		}
		else if (x + 1== r && y + 1== c) {
			result += 4;
			cout << result-1 << '\n';
			return;
		}
	}
}


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	
	int input;
	int two_sqrt = 1;
	cin >> input >> r >> c;
	result = 0;
	r += 1;
	c += 1;
	for (int i = 0; i < input; i++)
		two_sqrt *= 2;
	zet(1, 1, two_sqrt);
}