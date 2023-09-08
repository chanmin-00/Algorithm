#include <stdio.h>
#include <stdlib.h>

int main(void) {
	long long int num_n, num_m, i, count;
	long long int* arr1;
	long long int* arr2;
	long long int a, b;

	while (1)
	{
        count = 0;
        scanf("%lld", &num_n);
		scanf("%lld", &num_m);
		if (num_n == 0 && num_m == 0)
			break;
		arr1 = (long long int*) malloc(sizeof(long long int) * num_n);
		arr2 = (long long int*) malloc(sizeof(long long int) * num_m);

		for (i = 0; i < num_n; i++)
			scanf("%lld", &arr1[i]);
		for (i = 0; i < num_m; i++)
			scanf("%lld", &arr2[i]);
		a = 0;
		b = 0;
		while (a < num_n && b < num_m)
		{
			if (arr1[a] > arr2[b])
				b++;
			else if (arr1[a] < arr2[b])
				a++;
			else
			{
				a++;
				b++;
				count++;
			}
		}
		printf("%d\n", count);
	}
	return 0;
}

