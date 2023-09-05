#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void rev_str(int first, int second, char* tmp);

int main(void)
{
	char *str;
	char *min;
	int len,first;

	str = (char *) malloc(sizeof(char) * 51);
	first = 0;
	scanf("%s", str);
	len = strlen(str);
	for(int i=0;i<len-2;i++)
	{
		for(int j=i+1;j<len-1;j++)
		{
			char *tmp = strdup(str);
	                if (tmp == NULL)
        	        {
                	        free(str);
                        	return 0;
	                }	
			rev_str(0, i, tmp);
			rev_str(i+1, j, tmp);
			rev_str(j+1, len-1, tmp);
			if (first == 0)
			{
				min = strdup(tmp);
				first = 1;
			}
			else {
				if (strcmp(tmp, min) < 0)
					strcpy(min, tmp);
			}
			free(tmp);
		}		
	}
	printf("%s\n", min);
	return 0;
}

void rev_str(int first, int second, char* tmp)
{
	while (first < second) 
	{
		char c = tmp[first];
		tmp[first] = tmp[second];
		tmp[second] = c;
		first++;
		second--;
	}
}
