#include <stdio.h>
#include <stdlib.h>

void change_size(int **arr, int capacity);
int paelindrom(int num);

int main(void)
{
	int num;
	int count, capacity;
	int *save_arr;

	count = 0;
	capacity = 2;
	save_arr = (int *) malloc(sizeof(int) * 2);
	while(1)
	{
		scanf("%d", &num);
		if (count == capacity)
		{
			change_size(&save_arr, capacity);
			capacity *= 2;
		}
		save_arr[count] = num;
		count++;
		if (num == 0)
			break;
	}
	for(int i=0;save_arr[i]!=0;i++)
	{
		if (paelindrom(save_arr[i]))
			printf("yes\n");
		else
			printf("no\n");
	}
	return 0;
}

void change_size(int **arr, int capacity) // 포인터의 값을 바꿀려고 함
{
	// 포인터의 값을 바꿀려고 하기 때문에 포인터를 가리키는 포인터를
	// 매개변수로 받아옴, 그렇게 하게 되면서 포인터 원본의 값 변경 가능
	int *tmp;

	tmp = (int *) malloc(sizeof(int) * 2 * capacity);
	for(int i=0;i<capacity;i++)
	{
		tmp[i] = (*arr)[i];
	}
	free(*arr);
	*arr = tmp;
}

int paelindrom(int num)
{
	int jarisu = 0;
	int sqrt_jarisu = 1;
	int ten = 10;

	for (int i=num;i>0;)
	{
		i /= 10;
		jarisu++;
	}
	if (jarisu == 1)
		return 1;	
	for (int i=1;i<jarisu;i++)
		sqrt_jarisu *= 10;
	for (int i=0;i<jarisu/2;i++)
	{
		if(num/sqrt_jarisu != num % ten)
			return 0;
		num %= sqrt_jarisu;
		num /= 10;
		sqrt_jarisu /= 100;
	}
	return 1;
}




