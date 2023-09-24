#include <stdio.h>
#include <string.h>
#include <stdlib.h>

//20291 백준 파일정리

struct str_tree{
	char file_name[100];
	int count;
	struct str_tree* left;
	struct str_tree* right;
};

void find_dot(char* str)
{
	char *dot_index;
	int count = 0;

	dot_index = strstr(str, ".");
	dot_index++;
	while (1)
	{
		str[count] = dot_index[count];
		if (dot_index[count] == '\0')
			break;
		count++;
	}
}

void insert_tree(struct str_tree** root, char* str)
{
	struct str_tree* p = *root;
	struct str_tree* pp = 0;
	while (p)
	{
		if (strcmp(str, p->file_name) < 0)
		{
			pp = p;
			p = p->left;
		}
		else if (strcmp(str, p->file_name) > 0)
		{
			pp = p;
			p = p->right;
		}
		else
		{
			(p->count)++;
			return;
		}
	}
	p = (struct str_tree*)malloc(sizeof(struct str_tree) * 1);
	strcpy(p->file_name, str);
	p->count = 1;
	if (*root)
	{
		if (strcmp(str, pp->file_name) < 0)
			pp->left = p;
		else
			pp->right = p;
	}
	else
		(*root) = p;
}

void middle_order(struct str_tree* cur_node)
{
	if (cur_node)
	{
		middle_order(cur_node->left);
		printf("%s", cur_node->file_name);
		printf(" ");
		printf("%d\n", cur_node->count);
		middle_order(cur_node->right);
	}
}

int main(void)
{
	int count;
	char str[101];
	struct str_tree* root = 0;

	scanf("%d", &count);
	for (int i = 0; i < count; i++)
	{
		scanf("%s", str);
		find_dot(str);
		insert_tree(&root, str); // 트리에 삽입
	}
	middle_order(root); // 중위 순회를 통한 출력
}

