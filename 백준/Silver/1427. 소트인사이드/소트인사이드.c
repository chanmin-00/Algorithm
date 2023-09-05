#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	long long int num, i;
	long long int jarisu = 0;
	int *tmp_arr;
	int tmp;

	num = 0;
	scanf("%lld", &num);
	for(i = num;i>0;)
	{
		jarisu++;
		i /= 10;
	}
	tmp_arr = (int *) malloc(sizeof(int) * jarisu);
	for(i=0;i<jarisu;i++)
	{
		tmp_arr[i] = num % 10;
		num/=10;
	}
	for(int j=0;j<jarisu-1;j++)
	{
		for(int k=j+1;k<jarisu;k++)
		{
			if(tmp_arr[j]<tmp_arr[k])
			{
				tmp = tmp_arr[j];
				tmp_arr[j] = tmp_arr[k];
				tmp_arr[k] = tmp;
			}
		}
	}
	for(int j=0;j<jarisu;j++)
	{
		printf("%d", tmp_arr[j]);
	}
	printf("\n");
	return 0;
}



