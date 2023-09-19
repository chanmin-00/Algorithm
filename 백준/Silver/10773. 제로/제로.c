#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
	int count, tmp;
	int top = 0;
	int result = 0;

	scanf("%d", &count);
	int* stack = (int*)malloc(sizeof(int) * count);
	for (int i = 0; i < count; i++)
	{
		scanf("%d", &tmp);
		if (tmp != 0)
		{
			stack[top] = tmp;
			top++;
		}
		else
		{
			top--;
		}
	}
	for (int i = 0; i < top; i++)
	{
		result += stack[i];
	}
	printf("%d\n", result);
}
