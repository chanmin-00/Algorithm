#include <stdio.h>

int result[3];
void comb(int *arr, int *min, int n, int r);
int min_baesu(void);

int main(void)
{
	int arr[5];
	int min = 1000000;
	for(int i=0;i<5;i++)
	{
		scanf("%d", &arr[i]);
	}
	comb(arr, &min, 5, 3);
	printf("%d\n", min);
}

void comb(int *arr, int *min, int n, int r)
{
	if (r == 0)
	{
		if (*min > min_baesu())
		{
			*min = min_baesu();
		}
		return ;
	}
	if (n < r)
		return ;
	else {
		result[r-1] = arr[n-1];
		comb(arr, min, n-1, r-1); //선택된 경우
		comb(arr, min, n-1, r);
	}
}

int min_baesu(void)
// 세 수의 최소공배수를 구하는 공식 => ab, bc, ca의 최대 공약수로 세 수의 곱을 나눈 것
{
	int max_aksu = 1;
	int min;
	int num1 = result[0] * result[1];
	int num2 = result[0] * result[2];
	int num3 = result[1] * result[2];
	min = (num1 < num2 ? num1 : num2);
	min = (min < num3 ? min : num3);
	for (int i=1;i<=min;i++)
	{
		if (num1 % i == 0 && num2 % i ==0 && num3 % i == 0)
			max_aksu = i;
	}
	return (result[0] * result[1] * result[2]) / max_aksu;
}
	
		




