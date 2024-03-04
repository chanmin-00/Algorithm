#include <iostream>
#include <algorithm>

using namespace::std;

int heap[2250001];

void pushHeap(int& heapSize, int input) {

	int currentIndex = ++heapSize;

	while (currentIndex > 1 && heap[currentIndex / 2] < input) {
		heap[currentIndex] = heap[currentIndex / 2];
		currentIndex /= 2;
	}
	heap[currentIndex] = input;

}

int popHeap(int& heapSize) {

	int returnValue = heap[1];
	int lastValue = heap[heapSize--];
	int parentIndex = 1;
	int childIndex = 2;

	while (childIndex <= heapSize) {
		if (childIndex < heapSize) {
			if (heap[childIndex] < heap[childIndex + 1])
				childIndex++;
		}
		if (lastValue >= heap[childIndex])
			break;
		else {
			heap[parentIndex] = heap[childIndex];
			parentIndex = childIndex;
			childIndex = parentIndex * 2;
		}
	}
	heap[parentIndex] = lastValue;
	return returnValue;
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	int heapSize = 0;
	int input;
	int result;

	cin >> n;

	for (int i = 1; i <= n * n; i++) {
		
		cin >> input;
		pushHeap(heapSize, input);
	}

	for (int i = 1; i <= n; i++) {
		result = popHeap(heapSize);
	}

	cout << result << "\n";
}

