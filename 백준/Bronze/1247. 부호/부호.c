#include <stdio.h>

int main(void)
{
	long long int tmp_num;
	long long int sum, prv, over_underflow;
	char result[3];

	for(int i=0;i<3;i++)
	{
		scanf("%lld", &tmp_num);
		sum = 0;
		over_underflow = 0;
		prv = 0;
		for(long long int j=0;j<tmp_num;j++)
		{
			long long int tmp;
			prv = sum;
			scanf("%lld", &tmp);
			sum += tmp;
			if (tmp > 0 && prv > 0 && sum < 0) over_underflow++;
			if (tmp < 0 && prv < 0 && sum > 0) over_underflow--;
		}
		if (over_underflow > 0)
			result[i] = '+';
		else if (over_underflow < 0)
			result[i] = '-';
		else
		{
			if (sum > 0)
				result[i] = '+';
			else if (sum == 0)
				result[i] = '0';
			else
				result[i] = '-';
		}
	}
	for(int i=0;i<3;i++)
	{
		printf("%c\n", result[i]);
	}
}

