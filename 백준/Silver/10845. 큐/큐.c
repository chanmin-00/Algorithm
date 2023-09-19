#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void push(int* queue, int* back, int x, int* size);
void pop(int* queue, int* front, int* size);
void empty(int size);
void front_method(int* queue, int front, int size);
void back_method(int* queue, int back, int size);

int main(void)
{
	int queue[10001];
	int front = 0;
	int back = 0;
	int size = 0;
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
			push(queue, &back, x, &size);
		}
		else if (!strcmp(cmd, "pop"))
		{
			pop(queue, &front, &size);
		}
		else if (!strcmp(cmd, "size"))
		{
			printf("%d\n", size);
		}
		else if (!strcmp(cmd, "empty"))
		{
			empty(size);
		}
		else if (!strcmp(cmd, "front"))
		{
			front_method(queue, front, size);
		}
		else
		{
			back_method(queue, back, size);
		}

	}
}

void push(int* queue, int* back, int x, int *size)
{
	queue[*back] = x;
	(*back)++;
	(*size)++;
}

void pop(int* queue, int *front, int *size)
{
	if (*size == 0)
	{
		printf("-1\n");
	}
	else
	{
		printf("%d\n", queue[(*front)++]);
		(*size)--;
	}

}

void empty(int size)
{
	if (size == 0)
	{
		printf("1\n");
	}
	else
	{
		printf("0\n");
	}
}

void front_method(int *queue,int front,int size)
{
	if (size == 0)
	{
		printf("-1\n");
	}
	else
	{
		printf("%d\n", queue[front]);
	}
}

void back_method(int* queue, int back, int size)
{
	if (size == 0)
	{
		printf("-1\n");
	}
	else
	{
		printf("%d\n", queue[back-1]);
	}
}