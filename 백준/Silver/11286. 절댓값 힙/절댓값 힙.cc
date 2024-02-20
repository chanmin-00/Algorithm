#include <iostream>
#include <algorithm>

using namespace::std;

void push_heap(long long int* heap, long long int* heapSize, long long int num) {

	long long int currentNode = ++(*heapSize);
	while (currentNode > 1 && abs(heap[currentNode / 2]) >= abs(num)) {
		if (abs(heap[currentNode / 2]) == abs(num)) {
			if (heap[currentNode / 2] > num) {
				heap[currentNode] = heap[currentNode / 2];
				currentNode /= 2;
			} 
			else
				break;
		}
		else {
			heap[currentNode] = heap[currentNode / 2];
			currentNode /= 2;
		}
	}
	heap[currentNode] = num;
}

void pop_heap(long long int* heap,long long int* heapSize) {
	
	if (*heapSize == 0) {
		cout << '0' << '\n';
	}
	else {
		cout << heap[1] << "\n";
		
		long long int lastNum = heap[(*heapSize)--];
		long long int parentIndex = 1;
		long long int childIndex = 2;

		while (childIndex <= *heapSize) {
			if (childIndex < *heapSize && abs(heap[childIndex]) >= abs(heap[childIndex + 1])) {
				if (abs(heap[childIndex]) == abs(heap[childIndex + 1])) {
					if (heap[childIndex] > heap[childIndex + 1]) {
						childIndex++;
					}
				}
				else {
					childIndex++;
				}
			}

			if (abs(lastNum) < abs(heap[childIndex]))
				break;
			if (abs(lastNum) == abs(heap[childIndex])) {
				if (lastNum < heap[childIndex]) {
					break;
				}
			}

			heap[parentIndex] = heap[childIndex];
			parentIndex = childIndex; childIndex *= 2;
		}
		heap[parentIndex] = lastNum;
	}
}


// 배열을 이용하여 최소 힙 구현
int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	long long int n, num;
	long long int* heap;
	long long int heapSize = 0;

	cin >> n;
	
	heap = new long long int[n + 1];

	for (int i = 0; i < n; i++) {
		cin >> num;
		if (num == 0) {
			pop_heap(heap, &heapSize);
		}
		else {
			push_heap(heap, &heapSize, num);
		}
	}
	
}