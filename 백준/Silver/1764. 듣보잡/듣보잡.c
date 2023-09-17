#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compare(const void* tmp1, const void* tmp2);
int binary_search(char** n_arr, const char* x, const int n);

int main(void)
{
	int n_count, m_count;

	scanf("%d", &n_count);
	scanf("%d", &m_count);
	char** n_arr = (char**)malloc(sizeof(char*) * n_count);
	char** m_arr = (char**)malloc(sizeof(char*) * m_count);
	char** result = (char**)malloc(sizeof(char*) * m_count);
	for (int i = 0; i < n_count; i++)
	{
		n_arr[i] = (char*)malloc(sizeof(char) * 21);
		scanf("%s", n_arr[i]);
	}
	for (int i = 0; i < m_count; i++)
	{
		m_arr[i] = (char*)malloc(sizeof(char) * 21);
		scanf("%s", m_arr[i]);
	}
	qsort(n_arr, n_count, sizeof(char*), compare);
	int count = 0;
	for (int i = 0; i < m_count; i++)
	{
		if (binary_search(n_arr, m_arr[i], n_count) != -1)
		{
			result[count] = m_arr[i];
			count++;
		}
	}
	qsort(result, count, sizeof(char*), compare);
	printf("%d\n", count);
	for(int i = 0; i < count; i++)
	{
		printf("%s\n", result[i]);
	}

}

int compare(const void* tmp1, const void* tmp2) // qsort 함수의 비교함수 정의
{
	char *str1 = *(char**)tmp1;
	char *str2 = *(char**)tmp2;
	if (strcmp(str1, str2)<0)
		return -1;
	else if (strcmp(str1, str2)>0)
		return 1;
	else
		return 0;
}

int binary_search(char** n_arr, const char* x, const int n)
{
	int left = 0, right = n - 1;
	while (left <= right)
	{
		int middle = (left + right) / 2;
		if (strcmp(x,n_arr[middle]) < 0) right = middle - 1;
		else if (strcmp(x, n_arr[middle]) > 0) left = middle + 1;
		else return middle;
	}
	return -1;
}
