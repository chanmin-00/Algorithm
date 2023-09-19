#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void empty(int top);
void push(int* stack, int *top, int x);
void pop(int* stack, int *top);

int main(void)
{
	int stack[10001];
	int top = 0;
	int x;
	char cmd[6];

	int n_count;
	scanf("%d", &n_count);
	for (int i = 0; i < n_count; i++)
	{
		scanf("%s", cmd);
		if (!strcmp(cmd, "push"))
		{
			scanf("%d", &x);
			push(stack, &top, x);
		}
		else if (!strcmp(cmd, "pop"))
		{
			pop(stack, &top);
		}
		else if (!strcmp(cmd, "size"))
		{
			printf("%d\n", top);
		}
		else if (!strcmp(cmd, "empty"))
		{
			empty(top);
		}
		else
		{
			if (top == 0)
				printf("-1\n");
			else
				printf("%d\n", stack[top - 1]);
		}
	}
}

void push(int* stack, int* top, int x)
{
	stack[*top] = x;
	(*top)++;
}

void pop(int* stack, int *top)
{
	if (*top == 0)
	{
		printf("-1\n");
	}
	else
	{
		printf("%d\n", stack[--(*top)]);
	}
}

void empty(int top)
{
	if (top == 0)
	{
		printf("1\n");
	}
	else
	{
		printf("0\n");
	}
}
