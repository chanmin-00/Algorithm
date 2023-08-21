#include <stdio.h>

int main(void)
{
	int first_num;
	int new_num;
	int result;
	int tmp_first;

	result = 0;
	new_num = 0;
	scanf("%d", &first_num);
	tmp_first = first_num;
	while (1)
	{
		new_num = (((tmp_first / 10) + (tmp_first % 10)) % 10);
		new_num	+= ((tmp_first % 10) * 10);
		result++;
		if (new_num == first_num)
		{
			printf("%d\n", result);
			return 0;
		}
		tmp_first = new_num;
	}
	return 0;
}