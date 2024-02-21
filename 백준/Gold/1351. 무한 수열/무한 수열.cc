#include <iostream>
#include <algorithm>
#include <map>

using namespace::std;

long infArray(long n, long p, long q, map<long, long>& A) {

	if (A.find(n) == A.end()) {
		A.insert({ n, infArray(n / p, p, q, A) + infArray(n / q, p, q, A) });
	}
	return A.find(n)->second;
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	long n, p, q;
	long result;
	
	cin >> n >> p >> q;
	map<long , long> A;

	A.insert({ 0, 1 });
	result = infArray(n, p, q, A);
	cout << result << endl;
}