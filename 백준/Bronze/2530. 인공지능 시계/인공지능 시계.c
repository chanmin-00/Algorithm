#include <stdio.h>

int main(void)
{
	int hour, minute, sec;
	int total;
	int time;
	int comp_time;


	scanf("%d", &hour);
	scanf("%d", &minute);
	scanf("%d", &sec);
	scanf("%d", &time);

	total = hour * 60 * 60 + minute * 60 + sec;
	total += time;
	comp_time = 24 * 60 * 60;
	if(total < comp_time)
	{
		hour = total / (60 * 60);
		minute = (total % (60 * 60)) / 60;
		sec = (total % (60 * 60)) % 60;
	}
	else
	{
		total %= comp_time;
		hour = total / (60 * 60);
                minute = (total % (60 * 60)) / 60;
                sec = (total % (60 * 60)) % 60;
	}
	printf("%d", hour);
	printf("%s", " ");
	printf("%d", minute);
	printf("%s", " ");
	printf("%d", sec);
	printf("%s", " ");
	printf("\n");
	return 0;
}