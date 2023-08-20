#include <stdio.h>

int main(void)
{
	int people;
	int width;
	int total;
	int news[5];

	scanf("%d", &people);
	scanf("%d", &width);
	
	for(int i=0;i < 5;i++)
		scanf("%d", &news[i]);
	total = people * width;
	for(int i=0;i < 5;i++)
	{
		news[i] = news[i] - total;
		printf("%d", news[i]);
		printf("%s", " ");
	}
	printf("\n");
}