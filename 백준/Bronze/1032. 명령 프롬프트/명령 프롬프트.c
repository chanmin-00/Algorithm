#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
	int count;
	int len;
	int yes_question;
	char **string_arr;

	scanf("%d", &count);
	yes_question = 0;
	string_arr = (char **) malloc(sizeof(char *) * count);
	for(int i=0;i<count;i++)
	{
		string_arr[i] = (char *) malloc(sizeof(char) * 51);
		scanf("%s", string_arr[i]);
	}
	len = strlen(string_arr[0]);
	for(int i=0;i<len;i++)
	{
		yes_question = 0;
		for(int j=1;j<count;j++)
		{
			if (string_arr[0][i] != string_arr[j][i])
			{
				printf("?");
				yes_question = 1;
				break;
			}
		}
		if(!yes_question)
			printf("%c", string_arr[0][i]);
	}
	printf("\n");
	return 0;
}

