#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void replace_croatia(char* str, char* croatia, int* count);

int main(void)
{
	char *str;
	int count = 0;
	int len;
	char** croatia = (char**)malloc(sizeof(char*) * 8);
	for (int i = 0; i < 8; i++)
	{
		croatia[i] = (char*)malloc(sizeof(char) * 4);
	}
	croatia[0] = "dz=";
	croatia[1] = "c-";
	croatia[2] = "c=";
	croatia[3] = "d-";
	croatia[4] = "lj";
	croatia[5] = "nj";
	croatia[6] = "s=";
	croatia[7] = "z=";
	
	//char croatia[8][4] = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

	str = (char*)malloc(sizeof(char) * 101);
	scanf("%s", str);
	for (int i = 0; i < 8; i++)
	{
		replace_croatia(str, croatia[i], &count);
	}
	len = strlen(str);
	for (int i = 0; i < len; i++)
	{
		if (str[i] == ' ')
		{
			continue;
		}
		count++;
	}
	printf("%d\n", count);
	return 0;
}

void replace_croatia(char *str,char* croatia, int *count)
{
	char* ptr = strstr(str, croatia);
	int len = strlen(croatia);
	while (ptr)
	{
		for (int i = 0; i < len; i++)
		{
			strncpy(ptr, " ", 1);
			ptr++;
		}
		ptr = strstr(str, croatia);
		(*count)++;
	}
}
