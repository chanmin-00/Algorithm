#include <iostream>
#include <algorithm>

using namespace::std;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int i;
	int min;

	i = 0;
	min = 100001;

	cin >> n;
	while (i <= (n / 5)) {
		int j;
		if ((n - 5 * i) % 2 == 0) {
			j = (n - 5 * i) / 2;
			if (min > (i+j)) {
				min = i + j;
			}
		}
		i++;
	}
	if (min == 100001)
		cout << -1 << endl;
	else 
		cout<< min << endl;
}