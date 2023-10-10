#include <iostream>
#include <algorithm>

using namespace::std;

int max_heap[100001];
int heap_size;

int pop_heap() {
	int ans = max_heap[1];
	int last = max_heap[heap_size--];
	int currentNode = 1;
	int child = 2;
	while (child <= heap_size) {
		if (child < heap_size && max_heap[child] < max_heap[child + 1])
			child = child + 1;
		if (last >= max_heap[child])
			break;
		max_heap[currentNode] = max_heap[child];
		currentNode = child;
		child = 2 * currentNode;
	}
	max_heap[currentNode] = last;
	return ans;
}

void insert_heap(int num) {
	
	if (heap_size == 0) {
		max_heap[++heap_size] = num;
	}
	else {
		int currentNode = ++heap_size;
		while (currentNode >  1 && num > max_heap[currentNode / 2]) {
			max_heap[currentNode] = max_heap[currentNode / 2];
			currentNode = currentNode / 2;
		}
		max_heap[currentNode] = num;
	}
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int count;
	int num;
	int output;
	
	cin >> count;
	heap_size = 0;
	for (int i = 0; i < count; i++) {
		cin >> num;
		if (num == 0) {
			if (heap_size == 0) {
				cout << '0' << '\n';
			}
			else
			{
					output = pop_heap();
					cout << output << '\n';
			}
		}
		else
			insert_heap(num);
	}

}
