#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef	struct {
	char* name;
	int work;
} employ;

int compare(const void* tmp1, const void* tmp2)
{
	employ name1 = *(employ*)tmp1;
	employ name2 = *(employ*)tmp2;

	if (strcmp(name1.name, name2.name) < 0)
		return 1;
	else if (strcmp(name1.name, name2.name) > 0)
		return -1;
	else
		return 0;
}

int main(void)
{
	int count;
	char* name;
	char en_le[6];
	employ* list;

	scanf("%d", &count);
	list = (employ*)malloc(sizeof(employ) * (count+2));
	for (int i = 0; i < count; i++)
	{
		name = (char*)malloc(sizeof(char) * 6);
		scanf("%s", name);
		scanf("%s", en_le);
		list[i].name = strdup(name);
		if (!strcmp(en_le, "enter"))
			list[i].work = 1;
		else
			list[i].work = 0;
	}
	qsort(list, count, sizeof(employ), compare);

	for (int i = 0; i < count-1; i++)
	{
		if (!strcmp(list[i].name, list[i + 1].name))
		{
			i++;
		}
		else if (i == count - 1)
		{
			printf("%s\n", list[i].name);
		}
		else
			printf("%s\n", list[i].name);
	}
	if (list[count - 1].work)
		printf("%s\n", list[count-1].name);
}