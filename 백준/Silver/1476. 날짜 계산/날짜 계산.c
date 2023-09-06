#include <stdio.h>

int main(void)
{
	int earth, sun, moon;
	int num1, num2, num3;
	int year = 0;

	earth = 0;
	sun = 0;
	moon = 0;
	scanf("%d", &num1);
	scanf("%d", &num2);
	scanf("%d", &num3);

	while (1)
	{
		earth++;
		sun++;
		moon++;
		if (earth > 15)
			earth = 1;
		if (sun > 28)
			sun = 1;
		if (moon > 19)
			moon = 1;
		year++;
		if (earth == num1 && sun == num2 && moon == num3)
		{
			printf("%d\n", year);
			break;
		}
	}
}