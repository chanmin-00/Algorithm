#include <stdio.h>
#include <stdlib.h>

// m개 중 n개를 선택하는 경우의 수 구하기
// bottom_up 동적계획법 방식을 사용한 조합 계산
int comb_nm(int m, int n)
{
	int arr[40][40];

	for(int i=0;i<=m;i++)
	{
		for(int j=0;j<=n;j++)
		{
			if(i == j || j == 0)
				arr[i][j] = 1;
			else
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
		}
	}
	return arr[m][n];
	// 특정 수를 선택하는 경우와 선택하지 않는 경우로 나뉨
}

int main(void)
{
	int test_case;
	int *result_arr;
	int n, m;

	scanf("%d", &test_case);
	result_arr = (int *) malloc(sizeof(int) * test_case);
	for(int i=0;i<test_case;i++)
	{
		scanf("%d", &n);
		scanf("%d", &m);
		result_arr[i] = comb_nm(m, n);
	}
	for(int i=0;i<test_case;i++)
	{
		printf("%d\n", result_arr[i]);
	}
	return 0;
}	