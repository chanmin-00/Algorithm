#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int count, result;
	int* arr;
	
	result = 1;
	scanf("%d", &count);
	arr = (int*)malloc(sizeof(int) * count);
	for (int i = 0; i < count; i++)
	{
		scanf("%d", &arr[i]);
	}
	for (int i = count - 2; i > -1; i--)
	{
		if (arr[i] > arr[count - 1])
		{
			arr[count - 1] = arr[i];
			result++;
		}
	}
	printf("%d\n", result);
	return 0;
}