#include <stdio.h>

// 비트 마스킹을 통해 풀기
// 비트 연산을 통하여 풀기
int main(void)
{
	int x_cm;
	int count;

	count = 0;
	scanf("%d", &x_cm);
	for(int i=7;i>=0;--i)
	{
		if(((x_cm >> i) & 1) == 1) // >> i i만큼 비트 수를 이동
					   // 제일 좌측부터 비트 검사하기 위함
					   // 비트를 옮기면 좌측부터 0으로 채워짐
			count++;
	}
	printf("%d\n", count);
	return 0;
}

