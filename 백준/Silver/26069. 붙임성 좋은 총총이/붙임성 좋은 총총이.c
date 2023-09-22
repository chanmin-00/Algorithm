#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct name_tree {
	char name[21];
	struct name_tree* left;
	struct name_tree* right;
};

void insert_tree(struct name_tree** root, char *name)
{
	struct name_tree* p = *root;
	struct name_tree* pp = 0;
	while (p)
	{
		if (strcmp(name, p->name)<0)
		{
			pp = p;
			p = p->left;
		}
		else if (strcmp(name, p->name)>0)
		{
			pp = p;
			p = p->right;
		}
		else
		{
			return;
		}
	}
	p = (struct name_tree*)malloc(sizeof(struct name_tree) * 1);
	strcpy(p->name, name);

	if (strcmp(name, pp->name) < 0)
		pp->left = p;
	else
		pp->right = p;
}

int search_tree(struct name_tree** root, char* name)
{
	struct name_tree* p = *root;
	while (p)
	{
		if (strcmp(name, p->name) < 0)
		{
			p = p->left;
		}
		else if (strcmp(name, p->name) > 0)
		{
			p = p->right;
		}
		else
		{
			return 1;
		}
	}
	return 0;
}


int main(void)
{
	char name1[21];
	char name2[21];
	int count;
	int result = 1;
	struct name_tree* root;

	root = (struct name_tree*)malloc(sizeof(struct name_tree)*1);
	strcpy(root->name,"ChongChong");
	scanf("%d", &count);
	for (int i = 0; i < count; i++)
	{
		scanf("%s", name1);
		scanf("%s", name2);
		if (search_tree(&root, name1) == 1 && search_tree(&root, name2) == 0)
		{
			insert_tree(&root, name2);
			result++;
		}
		else if (search_tree(&root, name1) == 0 && search_tree(&root, name2) == 1)
		{
			insert_tree(&root, name1);
			result++;
		}
	}
	printf("%d\n", result);
}

