#include <iostream>
#include <algorithm>

using namespace::std;

void pushHeap(long long*& heap,long long& heapSize,long long input) {
	
	long long currentNode = ++heapSize;

	while (currentNode > 1 && heap[currentNode / 2] > input) {
		heap[currentNode] = heap[currentNode / 2];
		currentNode /= 2;
	}
	heap[currentNode] = input;
}

long long popHeap(long long*& heap, long long& heapSize) {
	
	long long returnNum = heap[1];
	long long lastNum = heap[heapSize--];

	long long parentIndex = 1;
	long long childIndex = 2;
	
	while (childIndex <= heapSize) {
		if (childIndex < heapSize && heap[childIndex] > heap[childIndex + 1])
			childIndex++;
		if (lastNum <= heap[childIndex])
			break;
		heap[parentIndex] = heap[childIndex];
		parentIndex = childIndex; 
		childIndex *= 2;
	}
	heap[parentIndex] = lastNum;
	
	return returnNum;
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	long long n, input, heapSize;
	long long* heap;
	long long result = 0;

	cin >> n;

	heap = new long long[n + 1];
	heapSize = 0;
	
	for (int i = 0; i < n; i++) {
		cin >> input;

		pushHeap(heap, heapSize, input); // 최소힙에 삽입
	}
	
	long long num1, num2, newInput;

	while (heapSize != 1) {
		num1 = popHeap(heap, heapSize); // 최소힙에서 꺼내기
		num2 = popHeap(heap, heapSize);

		newInput = num1 + num2;
		result += newInput;
		pushHeap(heap, heapSize, newInput);
	}

	cout << result << endl;

}
