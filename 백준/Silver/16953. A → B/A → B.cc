#include <iostream>
#include <algorithm>
#include <queue>
#include <limits>

using namespace::std;

void a2b(int a, int b, long int& min);

struct a_node {
	long long int level;
	long long int value;
};

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	long long int a, b;
	long int min = INTMAX_MAX;

	cin >> a >> b;

	a2b(a, b, min);
	if (min == INTMAX_MAX) {
		cout << -1 << endl;
	}
	else {
		cout << min + 1 << endl;
	}
}


void a2b(int a, int b, long int& min) {
	queue<a_node> queue;
	a_node u,v;

	v.level = 0;
	v.value = a;
	queue.push(v);
	while (!queue.empty()) {
		v = queue.front();
		queue.pop();
		if (v.value == b || v.value == b) {
			if (min > (v.level)) {
				min = v.level;
			}
		}
		else {
			u.level = v.level + 1;
			u.value = v.value * 2;
			if(u.value <= b)
				queue.push(u);		
			u.value = v.value * 10 + 1;
			if(u.value <= b)
				queue.push(u);	
		}
	}

}