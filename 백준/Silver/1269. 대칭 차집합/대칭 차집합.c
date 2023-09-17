#include <stdio.h>
#include <stdlib.h>

int compare(const void* tmp1, const void* tmp2);
int binary_search(int* n_arr, const int x, const int n);

int main(void)
{
	int a_count, b_count;
	int* a_arr;
	int* b_arr;

	scanf("%d", &a_count);
	scanf("%d", &b_count);
	a_arr = (int*)malloc(sizeof(int) * a_count);
	b_arr = (int*)malloc(sizeof(int) * b_count);
	for (int i = 0; i < a_count; i++)
		scanf("%d", &a_arr[i]);
	for (int i = 0; i < b_count; i++)
		scanf("%d", &b_arr[i]);
	qsort(a_arr, a_count, sizeof(int), compare);
	qsort(b_arr, b_count, sizeof(int), compare);

	// A-B 구하기
	int* tmp_a = (int *) malloc(sizeof(int) * a_count);
	int index1 = 0;
	for (int i = 0; i < a_count; i++)
	{
		if (binary_search(b_arr, a_arr[i], b_count) == -1)
		{
			tmp_a[index1] = a_arr[i];
			index1++;
		}
	}
	// B-A 구하기
	int* tmp_b = (int*)malloc(sizeof(int) * b_count);
	int index2 = 0;
	for (int i = 0; i < b_count; i++)
	{
		if (binary_search(a_arr, b_arr[i], a_count) == -1)
		{
			tmp_b[index2] = b_arr[i];
			index2++;
		}
	}
	printf("%d\n", index1 + index2);
}

int compare(const void* tmp1, const void* tmp2) // qsort 함수의 비교함수 정의
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

int binary_search(int* n_arr, const int x, const int n)
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
