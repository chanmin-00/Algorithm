#include <stdio.h>
#include <stdlib.h>

int* sunyeol(int* arr, int index, int len);

int main(void)
{
	int arr_len, delete_index;
	int len;
	int* arr;
	
	scanf("%d", &arr_len);
	scanf("%d", &delete_index);
	printf("<");
	len = arr_len;
	arr = (int*)malloc(sizeof(int) * (arr_len));
	for (int i = 0; i < arr_len; i++)
	{
		arr[i] = i + 1;
	} // 초기 설정	
	int tmp = delete_index;
	for (int i = 0; i < arr_len; i++)
	{
		if (len == 1)
		{
			printf("%d", arr[0]);
			break;
		}
		printf("%d%s", arr[delete_index - 1],", ");
		len--;
		arr = sunyeol(arr, delete_index, len);
		delete_index = (tmp) % len;
        if (delete_index == 0)
              delete_index = len;
             

	}
	printf(">\n");

}

int* sunyeol(int* arr, int index, int len)
{
	int* tmp;
	int count = 0;
	tmp = (int*)malloc(sizeof(int) * len);
	for (int i = 0; i < len + 1 - index; i++)
	{
		tmp[i] = arr[index+i];
	}
	for (int i = len + 1 - index; i < len; i++)
	{
		tmp[i] = arr[count++];
	}
	return tmp;
}


