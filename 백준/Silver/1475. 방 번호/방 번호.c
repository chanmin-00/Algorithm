#include <stdio.h>

int	main(void)
{
	int num, tmp;
	int num_arr[10] = { 0,0,0,0,0,0,0,0,0,0};
	scanf("%d", &num);

	for (int i = num; i > 0;)
	{
		tmp = i % 10;
		if (tmp != 9 && tmp != 6)
		{
			num_arr[tmp]++;
		}
		else
		{
			if (num_arr[6] < num_arr[9])
				num_arr[6]++;
			else if (num_arr[6] > num_arr[9])
				num_arr[9]++;
			else
				num_arr[6]++;
		}
		i = i / 10;
	}

	for (int i = 0; i < 9; i++)
	{
		for (int j = i + 1; j < 10; j++)
		{
			if (num_arr[i] < num_arr[j])
			{
				tmp = num_arr[i];
				num_arr[i] = num_arr[j];
				num_arr[j] = tmp;
			}
		}
	}
	printf("%d", num_arr[0]);
	return 0;
}