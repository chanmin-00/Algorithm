#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct tree {
	char name[21];
	struct tree* left;
	struct tree* right;
};

void insert_tree(struct tree** root, char* str, int* result)
{
	struct tree* p = *root;
	struct tree* pp = 0;
	while (p)
	{
		if (strcmp(str, p->name) < 0)
		{
			pp = p;
			p = p->left;
		}
		else if (strcmp(str, p->name) > 0)
		{
			pp = p;
			p = p->right;
		}
		else
		{
			return;
		}
	}
	// 삽입과정 진행, 새 객체 생성
	(*result)++;
	p = (struct tree*)malloc(sizeof(struct tree) * 1);
	strcpy(p->name, str);
	if (*root)
	{
		if (strcmp(str, pp->name) < 0)
			pp->left = p;
		else
			pp->right = p;
	}
	else
	{
		(*root) = p;
	}
}

int main(void)
{
	int count;
	int result = 0;
	char str[21];
	struct tree* root;

	scanf("%d", &count);
	for (int i = 0; i < count; i++)
	{
		scanf("%s", str);
		if (!(strcmp(str, "ENTER")))
			root = 0;
		else
		{
			insert_tree(&root, str, &result);
		}
	}
	printf("%d\n", result);
}





