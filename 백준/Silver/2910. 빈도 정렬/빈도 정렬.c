#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct num_tree {
	int num;
	int count;
	int index;
	struct num_tree* left;
	struct num_tree* right;
};

void insert_num_tree(struct num_tree** root, int num, int* index)
{
	struct num_tree* p = *root;
	struct num_tree* pp = 0;
	while (p)
	{
		if (num < p->num)
		{
			pp = p;
			p = p->left;
		}
		else if (num > p->num)
		{
			pp = p;
			p = p->right;
		}
		else
		{
			p->count++;
			return;
		}
	}
	// 삽입과정 진행, 새 객체 생성
	p = (struct num_tree*)malloc(sizeof(struct num_tree) * 1);
	p->num = num;
	p->count = 1;
	p->index = (*index)++;
	if (*root)
	{
		if (num < pp->num)
			pp->left = p;
		else
			pp->right = p;
	}
	else
	{
		(*root) = p;
	}
}

void change_tree_arr(struct num_tree*  currentNode, struct num_tree* arr, int *index)
{
	// 이진트리 순회하면서 count최댓값 찾기
	if (currentNode)
	{
		arr[(*index)++] = *currentNode;
		change_tree_arr((currentNode)->left, arr, index);
		change_tree_arr((currentNode)->right, arr, index);
	}
}

int compare(const void* tmp1, const void* tmp2)
{
	struct num_tree num1 = *(struct num_tree*)tmp1;
	struct num_tree num2 = *(struct num_tree*)tmp2;

	if (num1.count < num2.count)
		return 1;
	else if (num1.count > num2.count)
		return -1;
	else
	{
		if (num1.index < num2.index)
			return -1;
		else
			return 1;
	}
}

int main(void)
{
	int capacity;
	int c_num;
	int index = 0;
	int* input_arr;
	struct num_tree* root = 0;

	scanf("%d", &capacity);
	scanf("%d", &c_num);
	input_arr = (int*)malloc(sizeof(int) * capacity);
	for (int i = 0; i < capacity; i++)
	{
		scanf("%d", &input_arr[i]);
	}
	for (int i = 0; i < capacity; i++)
	{
		insert_num_tree(&root, input_arr[i], &index);
	}
	struct num_tree sort_arr[1000];
	int count = 0;
	change_tree_arr(root, sort_arr, &count);
	qsort(sort_arr, count, sizeof(struct num_tree), compare);
	for (int i = 0; i < count; i++)
	{
		for (int j = 0; j < sort_arr[i].count; j++)
		{
			printf("%d", sort_arr[i].num);
			printf(" ");
		}
	}
	return 0;
}






