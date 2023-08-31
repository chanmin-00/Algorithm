#include <stdio.h>

int main(void)
{ 
	long long int up, down;
	long long int meter;
	long long int sum;

	sum = 0;
	scanf("%lld", &up);
	scanf("%lld", &down);
	scanf("%lld", &meter);
	if (up >= meter)
	{
		printf("1\n");
		return 0;
	}	
	sum = up - down;
	if ((meter-up) % sum != 0)
		printf("%lld\n", ((meter-up) / sum + 2));
	else
		printf("%lld\n", (meter-up) / sum + 1);
	return 0;
}
