#include <iostream>
#include <algorithm>
#include <string.h>

using namespace::std;


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, k;
	string str;
	int p_count;

	cin >> n >> k;
	cin >> str;
	p_count = 0;

	for (int i = 0; i < n; i++) {
		if (str[i] == 'P') {
			for (int j = i - k; j <= i + k; j++) {
				if (str[j] == 'H') {
					str[j] = 'X';
					p_count++;
					break;
				}
			}
		}
	}
	cout << p_count << endl;     
}