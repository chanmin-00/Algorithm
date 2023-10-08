#include <iostream>
#include <algorithm>

using namespace::std;

// 분할 정복
// 만들어진 정사각형 칸 안에 1이나 0만 존재하면
// 정사각형 변의 길이르 반으로 줄여가지 않는다
// 1 0 둘다 존재하면 정사각형 변의 길이를 반으로 줄여 재귀를 호출

int only_blue_white(int** square, int i, int j, int p, int q) {
	
	int flag = square[i][p];
	for (int width = i; width <= j; width++) {
		for (int height = p; height <= q; height++) {
			if (square[width][height] != flag)
				return -1;
		}
	}
	return flag;
}

void find_white_blue(int** square,int i, int j, int p, int q, int& white, int& blue) {
	if (i <= j && p <= q)
	{
		int flag = only_blue_white(square, i, j, p,q);
		int width = (i + j) / 2;
		int height = (p + q) / 2;
		if (flag == 0) {
			white++;
		}
		else if (flag == 1) {
			blue++;
		}
		else {
			find_white_blue(square, i, width, p, height,  white, blue);
			find_white_blue(square, i, width, height + 1, q, white, blue);
			find_white_blue(square, width + 1, j, p, height, white, blue);
			find_white_blue(square, width + 1, j, height + 1, q, white, blue);
		}
	}
}
int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	
	int square_len;
	int white = 0;
	int blue = 0;
	cin >> square_len;
	int** square = new int*[square_len+1];
	for (int i = 1; i <= square_len; i++) {
		square[i] = new int[square_len+1];
		for (int j = 1; j <= square_len; j++) {
			cin >> square[i][j];
		}
	}


	find_white_blue(square, 1, square_len, 1, square_len,  white, blue);
	cout << white << '\n';
	cout << blue << '\n';
	return 0;
}