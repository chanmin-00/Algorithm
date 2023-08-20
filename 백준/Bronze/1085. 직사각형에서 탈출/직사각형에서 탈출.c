#include <stdio.h>

int main(void)
{
	int x, y;
	int w, h;
	int min;
	int x_distance;
	int y_distance;

	scanf("%d %d %d %d", &x, &y, &w, &h);
	x_distance = w - x;
	y_distance = h - y;
	if (x < y)
		min = x;
	else 
		min = y;
	if (min > x_distance)
		min = x_distance;
        if (min > y_distance)
		min = y_distance;
	printf("%d\n",min);

}