#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int num, size;
	int front, rear, tmp;
	int* arr;

	front = 0;
	rear = 0;
	scanf("%d", &num);
	arr = (int*)malloc(sizeof(int) * (num + 1));
	size = num + 1;
	// push
	for (int i = 1; i <= num; i++)
	{
		rear = (rear + 1) % (num + 1);
		arr[rear] = i;
	}

	while (num != 1)
	{
		// pop
		front = (front + 1) % (size);
		tmp = arr[front];
		printf("%d", tmp);
		printf(" ");
		arr[front] = 0;
		// pop
		front = (front + 1) % (size);
		tmp = arr[front];
		arr[front] = 0;
		// push 
		rear = (rear + 1) % (size);
		arr[rear] = tmp;
		num--;
	}
	printf("%d\n", arr[rear]);
}