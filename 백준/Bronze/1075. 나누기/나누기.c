#include <stdio.h>

int main(void)
{
	long long int N;
	long long int F;
	long long int n_tmp;
	long long int i;
	int result[2];

	scanf("%lld", &N);
	scanf("%lld", &F);
	n_tmp = N / 100 * 100;
	N = (N / 100 + 1) * 100;
	for(i=n_tmp;i<=N;i++)
	{
		if (i % F == 0)
			break;
	}
	result[1] = i % 10;
	result[0] = i / 10 % 10;
	printf("%d",result[0]);
	printf("%d",result[1]);
	printf("\n");
	return 0;
}