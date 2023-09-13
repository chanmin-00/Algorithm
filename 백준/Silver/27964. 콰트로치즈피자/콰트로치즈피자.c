#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int compare(const void* tmp1, const void* tmp2);

int main(void) {
	int count, cheese_count, result;
	int len;
	char** pizza;
	char** cheese;

	cheese_count = 0;
	result = 1;
	scanf("%d", &count);
	pizza = (char**)malloc(sizeof(char*) * count);
	cheese = (char**)malloc(sizeof(char*) * count);

	for (int i = 0; i < count; i++)
	{
		pizza[i] = (char*)malloc(sizeof(char) * 101);
		scanf("%s", pizza[i]);
		len = strlen(pizza[i]) - 6;
		if (strstr(pizza[i]+len , "Cheese"))
		{
			cheese[cheese_count] = pizza[i];
			cheese_count++;
		}
	}
	qsort(cheese, cheese_count, sizeof(char*), compare);
	for (int i = 1; i < cheese_count; i++)
	{
		if (strcmp(cheese[i-1], cheese[i]) != 0)
			result++;
	}
	if (result > 3)
		printf("yummy\n");
	else
		printf("sad\n");
	return 0;
}

int compare(const void * tmp1, const void* tmp2)
{
	char* str1 = *(char**)tmp1;
	char* str2 = *(char**)tmp2;

	if (strcmp(str1, str2) < 0)
		return 1;
	else if (strcmp(str1, str2) > 0)
		return -1;
	else
		return 0;
}
