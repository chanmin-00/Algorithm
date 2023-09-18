#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
	int count;
	int result = 0;
	scanf("%d", &count);

	char** str_arr = (char**)malloc(sizeof(char*) * count);
	for (int i = 0; i < count; i++)
	{
		str_arr[i] = (char*)malloc(sizeof(char*) * 100001);
		scanf("%s", str_arr[i]);
	}
	for (int i = 0; i < count; i++)
	{
		int len = strlen(str_arr[i]);
		int top = 0;
		char tmp[100001];
		tmp[0] = str_arr[i][0];
		for (int j = 1; j < len; j++)
		{
			if (tmp[top] == str_arr[i][j])
				top--;
			else
			{
				top++;
				tmp[top] = str_arr[i][j];
			}
		}
		if (top == -1)
			result++;
	}
	printf("%d\n", result);


}
