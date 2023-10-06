#include <iostream>
#include <algorithm>

using namespace::std;

void push_heap(int *heap, int* heap_size, int num) {
	int currentNode = ++(*heap_size);
	while (currentNode > 1 && heap[currentNode / 2] > num) {
		heap[currentNode] = heap[currentNode / 2];
		currentNode /= 2;
	}
	heap[currentNode] = num;
}

void pop_heap(int *heap, int* heap_size) {
	if (*heap_size == 0) {
		cout << '0' << '\n';
	}
	else {
		cout << heap[1] << '\n';
		int last_index = heap[(*heap_size)--];
		int cnt_index = 1;
		int child_index = 2;
		while (child_index <= *heap_size) {
			if (child_index < *heap_size && heap[child_index] > heap[child_index + 1])
				child_index++;
			if (last_index <= heap[child_index]) break;
			heap[cnt_index] = heap[child_index];
			cnt_index = child_index; child_index *= 2;
		}
		heap[cnt_index] = last_index;
	}
}

// 배열을 이용하여 최소 힙 구현
int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int count, input;
	int* heap;
	int heapSize = 0;
	
	cin >> count;
	heap = new int[count+1];

	for (int i = 0; i < count; i++) {
		cin >> input;
		if (input == 0) {
			pop_heap(heap, &heapSize);
		}
		else {
			push_heap(heap, &heapSize, input);
		}
	}

}