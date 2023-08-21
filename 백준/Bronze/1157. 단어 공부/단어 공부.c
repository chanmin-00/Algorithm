#include <stdio.h>
#include <stdlib.h>

int ft_strlen(char *str)
{
	int i;

	i = 0;
	while (str[i] != '\0')
		i++;
	return i;
}

void make_low(char *str)
{
	int i;

	i = 0;
	while (str[i] != '\0')
	{
		if (str[i] >= 'a' && str[i] <= 'z')
			str[i] -= 32;
		i++;
	}
}

int main(void)
{
	char str[1000001];
	char *arr;
	int count;
	int *count_arr;
	int swp_int;
	char swp_char;
	int str_len;

	count = 0;
	scanf("%s", str);
	make_low(str);
	arr = (char *) malloc(sizeof(char) * ft_strlen(str));
	str_len = ft_strlen(str);
	for(int i=0;i<str_len;i++)
	{
		int j;
		for(j=0;j<count;j++)
		{
			if (str[i] == arr[j])
				break;
		}
		if (j == count)
		{	
			arr[count] = str[i];
			count++;
		}
	}
	count_arr = (int *) malloc(sizeof(int) * count);
	for(int i=0;i<count;i++) // 배열 0으로 초기화
	{
		count_arr[i] = 0;
	}
	for(int i=0;i<str_len;i++) // 각 단어의 개수 세기
	{
		for(int j=0;j<count;j++)
		{
			if (str[i] == arr[j])
			{
				count_arr[j]++;
			}
		}
	}
	for(int i=0;i<count-1;i++) // 배열 정렬하기
	{
		for(int j=i+1;j<count;j++)
		{
			if(count_arr[i] > count_arr[j])
			{
				swp_int = count_arr[i];
				swp_char = arr[i];
				count_arr[i] = count_arr[j];
				arr[i] = arr[j];
				count_arr[j] = swp_int;
				arr[j] = swp_char;
			}
		}
	}
	if (count_arr[count-1] == count_arr[count-2] && count > 1)
	{
		printf("?\n");
	}
	else
	{
		printf("%c\n", arr[count-1]);
	}

	return 0;
}




