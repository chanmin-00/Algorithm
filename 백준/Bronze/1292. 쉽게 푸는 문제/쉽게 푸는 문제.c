#include <stdio.h>

int count_sum(int num)
{
	int sum;
	int count;
	int sum_count;

	count = 1;
	sum_count = 1;
	sum = 0;
	while(sum_count <= num)
	{
		for(int i=0;i<count;i++)
		{
			sum += count;
			sum_count++;
			if (sum_count > num)
				break;
		}
		count++;
	}
	return sum;
}

int main(void)
{
	int a_num, b_num;
	int a_result, b_result;

	scanf("%d", &a_num);
	scanf("%d", &b_num);
	a_result = count_sum(a_num - 1);
	b_result = count_sum(b_num);
	printf("%d\n", b_result - a_result);
	return 0;
}