#include <iostream>
#include <algorithm>
#include <map>

using namespace::std;

long infArray(long n, long& p, long& q, long& x, long& y, map<long, long>& A) {

	if (n <= 0) return 1;
	if (A.find(n) == A.end()) {
		A.insert({ n, infArray(n / p - x, p, q, x, y, A) + infArray(n / q - y, p, q, x, y, A) });
	}
	return A.find(n)->second;
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	long n, p, q, x, y;
	long result;

	cin >> n >> p >> q >> x >> y;
	map<long, long> A;

	A.insert({ 0, 1 });
	result = infArray(n, p, q, x, y, A);
	cout << result << endl;
}