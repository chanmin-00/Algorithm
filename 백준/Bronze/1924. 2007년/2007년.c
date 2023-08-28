#include <stdio.h>

int include_31(int tmp)
{
	if (tmp==1||tmp==3||tmp==5||tmp==7||tmp==8||tmp==10||tmp==12)
		return 1;
	return 0;
}

int include_28(int tmp)
{
	if (tmp == 2)
		return 1;
	return 0;
}

int main(void)
{
	char day_arr[7][4] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
	int month, day;
	int sum;

	sum = 0;
	scanf("%d", &month);
	scanf("%d", &day);
	for(int i=1;i<month;i++)
	{
		if (include_31(i))
			sum+=31;
		else if(include_28(i))
			sum+=28;
		else
			sum+=30;
	}
	sum+=day;
	switch(sum % 7)
	{
		case 1 :
			printf("%s\n", day_arr[0]);
			return 0;
		case 2 :
			printf("%s\n", day_arr[1]);
			return 0;
		case 3 :
			printf("%s\n", day_arr[2]);
			return 0;
		case 4 :
			printf("%s\n", day_arr[3]);
			return 0;
		case 5 : 
			printf("%s\n", day_arr[4]);
			return 0;
		case 6 :
			printf("%s\n", day_arr[5]);
			return 0;
		case 0 :
			printf("%s\n", day_arr[6]);
			return 0;
	}
	return 0;
}
