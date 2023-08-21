#include <stdio.h>
#include <stdlib.h>

int count_n(int tmp)
{
	int count;
	count = 0;
	for(int i=2;i<tmp;i++)
	{
		if(tmp % i == 0)
			count++;
	}
	return count;
}

int main(void)
{
	int count;
	int *arr;
	int tmp;

	scanf("%d", &count);
	arr = (int *) malloc(sizeof(int) * count);
	for(int i=0;i < count;i++)
		scanf("%d", &arr[i]);

	for(int i=0;i<count-1;i++) // 배열 정렬
	{
		for(int j=i+1;j<count;j++)
		{
			if (arr[i] > arr[j])
			{
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
	}
	tmp = arr[count-1] + 1;
	// 약수의 개수 (2 + count)개만 존재해야 함
	// 배열에 담긴 것만 나눠줘야 함
	while(1)
	{
		int i = 0;
		for(;i<count;i++)
		{
			if (tmp % arr[i] != 0)
				break;
		}
		if ((i == count) && (count_n(tmp) == count))
		{
			printf("%d\n",tmp);
			return 0;
		}
		tmp++;
	}
	return 0;
}
	


