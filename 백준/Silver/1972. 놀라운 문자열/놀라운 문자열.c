#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct str_tree {
	char str[3];
	struct str_tree* left;
	struct str_tree* right;
};

int insert_tree(struct str_tree** root, char* str)
{
	struct str_tree* p = *root;
	struct str_tree* pp = 0;
	while (p)
	{
		if (strcmp(str, p->str) < 0)
		{
			pp = p;
			p = p->left;
		}
		else if (strcmp(str, p->str) > 0)
		{
			pp = p;
			p = p->right;
		}
		else
		{
			return 0;
		}
	}
	// 삽입과정 진행, 새 객체 생성
	p = (struct str_tree*)malloc(sizeof(struct str_tree) * 1);
	strcpy(p->str, str);
	if (*root)
	{
		if (strcmp(str, pp->str) < 0)
			pp->left = p;
		else
			pp->right = p;
	}
	else
	{
		(*root) = p;
	}
	return 1;
}

int decide_surprise(char* input_str)
{
	int len = strlen(input_str);
	int surprise;
	char *dest = (char *) malloc(sizeof(char) * 3);
	struct str_tree* root;

	for (int i = 0; i <  len - 1; i++)
	{
		root = 0;
        dest = (char *) malloc(sizeof(char) * 3);
		for (int j = 0; j < len - 1 - i; j++)
		{
			dest[0] = input_str[j];
			dest[1] = input_str[j + i + 1];
			dest[2] = '\0';
			surprise = insert_tree(&root, dest);
			if (surprise == 0)
            {
                 free(root);
                 return 0;
            }
		}
		free(root);
	}
	return 1;
}

int main(void)
{
	char input_str[81];

	while (1)
	{
		scanf("%s", input_str);
		if (!strcmp(input_str, "*"))
			break;
		if (decide_surprise(input_str))
		{
			printf("%s", input_str);
			printf(" is surprising.\n");
		}
		else
		{
			printf("%s", input_str);
			printf(" is NOT surprising.\n");
		}
	}
}


