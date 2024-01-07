#include <iostream>
#include <algorithm>

using namespace::std;

long long int w_or_h(int w, int h);
long long int dp[31][31];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, tmp, index;
	int* input = new int[1001];
	long long int result;
	
	index = 0;
	while (1) {
		cin >> tmp;
		if (tmp == 0)
			break;
		input[index] = tmp;
		index++;
	}

	for (int i = 0; i < 31; i++) {
		for (int j = 0; j < 31; j++) {
			dp[i][j] = 0;
		}
	}
		
	for(int i=0;i<index;i++){
		result = w_or_h(input[i], 0);
		cout << result << endl;
	}
}

long long int w_or_h(int w, int h) {
	if (dp[w][h] != 0) {
		return dp[w][h];
	}
	if (w == 0) {
		return 1;
	}
	if (w > 0 && h > 0) {
		dp[w][h] += w_or_h(w - 1, h + 1);
		dp[w][h] += w_or_h(w, h - 1);
	}
	else if (w > 0 && h == 0) {
		dp[w][h] += w_or_h(w - 1, h + 1);
	}
	return dp[w][h];
}