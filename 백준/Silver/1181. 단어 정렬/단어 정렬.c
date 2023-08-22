#include <stdio.h>
#include <stdlib.h> 
#include <string.h>


//비교 수행하는 함수
int compare(const void* str1, const void* str2) 
{   //길이순 정렬
	if (strlen((const char*)str1) > strlen((const char*)str2)) return 1;
	else if (strlen((const char*)str1) < strlen((const char*)str2)) return -1;
	//길이 같으면 사전순
	else return strcmp((char*)str1, (char*)str2);
} 
int main(void)
{    
	int count;
       	int length = 51;
	char arr[20000][51] = { 0 };
	scanf("%d", &count);

	for (int i = 0; i < count; i++)      
		scanf("%s", arr[i]);
	qsort(arr, count, sizeof(arr[0]), compare);
	//정렬 후 같은 문자열 생략
	for (int i = 0; i < count; i++) {
		if (strcmp(arr[i], arr[i+1]) != 0 || i == count - 1)
			printf("%s\n", arr[i]);
	}
	return 0;
}
