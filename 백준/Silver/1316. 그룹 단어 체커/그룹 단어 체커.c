#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int is_group(char *str);

int main(void)
{
	char **str_arr;
	int count, result;

	result = 0;
	scanf("%d", &count);
	str_arr = (char **) malloc(sizeof(char *) * count);
	for(int i=0;i<count;i++)
	{
		str_arr[i] = (char *) malloc(sizeof(char) * 101);
		scanf("%s", str_arr[i]);
	}

	for(int i=0;i<count;i++)
	{
		if (is_group(str_arr[i]))
		{
			result++;
		}
	}
	printf("%d\n", result);
}

int is_group(char *str)
{
	int len = strlen(str);
	int index;
	int count;
	for(int i=0;i<len-1;)
	{
		count = 0;
		index = 0;
		for(int j=i+1;j<len;j++)
		{
			if (str[i] != str[j])
			{
				if (count == 0)
					index = j;
				count++;
			}
			else if(str[i] == str[j])
			{
				if (count != 0)
				{
					return 0;
				}
			}
		}
		if (index != 0)
			i = index;
		else
			i=i+1;
	}
	return 1;
}

				
