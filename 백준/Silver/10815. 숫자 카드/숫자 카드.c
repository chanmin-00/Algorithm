#include <stdio.h>
#include <stdlib.h>

int compare(const void* tmp1, const void* tmp2);
int BinarySearch(int* n_arr, const int x, const int n);

int main(void)
{
	int n, m;
	int* n_arr;
	int* m_arr;
	int* result;

	scanf("%d", &n);
	n_arr = (int*)malloc(sizeof(int) * n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &n_arr[i]);
	}
	scanf("%d", &m);
	m_arr = (int*)malloc(sizeof(int) * m);
	result = (int*)malloc(sizeof(int) * m);
	for (int i = 0; i < m; i++)
	{
		scanf("%d", &m_arr[i]);
		result[i] = 0;
	}
	qsort(n_arr, n, sizeof(int), compare);

	for (int i = 0; i < m; i++)
	{
		if (BinarySearch(n_arr, m_arr[i], n) != -1)
		{
			result[i] = 1;
		}
	}

	for (int i = 0; i < m; i++)
	{
		printf("%d%s", result[i], " ");
	}
	printf("\n");

}

int compare(const void* tmp1, const void* tmp2)
{
	int num1 = *((int*)tmp1);
	int num2 = *((int*)tmp2);
	if (num1 > num2)
		return 1;
	else if (num1 < num2)
		return -1;
	else
		return 0;
}

int BinarySearch(int* n_arr, const int x, const int n)
{
	int left = 0, right = n - 1;
	while (left <= right)
	{
		int middle = (left + right) / 2;
		if (x < n_arr[middle]) right = middle - 1;
		else if (x > n_arr[middle]) left = middle + 1;
		else return middle;
	}
	return -1;
}
