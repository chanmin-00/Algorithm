#include <stdio.h>

int bigger_than_100(int* real_arr)
{
	int sum = 0;

	for(int i=0;i<7;i++)
	{
		sum+=real_arr[i];
	}
	if (sum > 100)
		return 0;
	if (sum == 100)
		return 100;
	return 1;
}

void print_result(int *real_arr)
{
	for(int i=0;i<7;i++)
	{
		printf("%d\n", real_arr[i]);
	}
}

int include_num(int arr_num, int *real_arr, int count)
{
	for(int i=0;i<count;i++)
	{
		if (real_arr[i] == arr_num)
			return 1;
	}
	return 0;
}

void make_good_arr(int *real_arr)
{
	int tmp;
	for(int i=0;i<6;i++)
	{
		for(int j=i;j<7;j++)
		{
			if (real_arr[i]>real_arr[j])
			{
				tmp = real_arr[i];
				real_arr[i] = real_arr[j];
				real_arr[j] = tmp;
			}
		}
	}
}

void scan_nanjaeng(int *arr, int *real_arr, int count, int* count_t)
{
	if ((*count_t) == 1 || count > 6)
		return;
	if ((count > 0) && (include_num(real_arr[count], real_arr, count)))
		return;
	if (bigger_than_100(real_arr))
	{
		if (bigger_than_100(real_arr) == 100 && count == 6)
		{
			make_good_arr(real_arr);
			print_result(real_arr);
			(*count_t)++;
			return ;
		}
		else
		{
			for (int i=0;i<9;i++)
			{
				real_arr[count + 1] = arr[i];
				scan_nanjaeng(arr, real_arr, count+1, count_t);
				real_arr[count + 1] = 0;
			}
		}
	}
}


int main(void)
{
	int nanjaeng[9];
	int real_nanjaeng[7] = {0, 0, 0, 0, 0, 0, 0};
	int count = 0;

	for(int i=0;i<9;i++)
	{
		scanf("%d", &nanjaeng[i]);
	}
	scan_nanjaeng(nanjaeng, real_nanjaeng, -1, &count);
}
