#include <stdio.h>

unsigned long long int Rev(unsigned long long int num);

int main(void)
{
	unsigned long long int num_x, num_y;
	unsigned long long int rev_x, rev_y;

	scanf("%lld", &num_x);
	scanf("%lld", &num_y);
	rev_x = Rev(num_x);
	rev_y = Rev(num_y);
	printf("%lld\n", Rev(rev_x+rev_y));
	return 0;
}

unsigned long long int Rev(unsigned long long int num)
{
	unsigned long long tmp = 0;
	unsigned long long int i;

	for(i=num;i>0;)
	{
		tmp = tmp * 10 + (i % 10);
		i /= 10;
	}
	return tmp;
}
	
