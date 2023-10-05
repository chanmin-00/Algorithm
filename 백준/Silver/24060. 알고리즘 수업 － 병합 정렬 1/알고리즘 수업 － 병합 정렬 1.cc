#include <iostream>
#include <algorithm>

using namespace::std;

void mergesort(int i, int j, int* arr, int save_count, int *count);
void merge(int i, int mid, int j, int* arr, int num, int *pnt);

void mergesort(int i, int j, int* arr, int save_count, int *count) {
	if (i < j) {
		int mid = (i+j)/2;
		mergesort(i, mid, arr, save_count, count);
		mergesort(mid+1, j, arr, save_count, count);
		merge(i, mid, j, arr, save_count, count);
	}

}

void merge(int i, int mid, int j,int* arr, int save_count, int *count) {
	int i_tmp = i;
	int j_tmp = mid+1;
	int t = 1;
	int* tmp = new int[j - i + 1+1];
	while (i_tmp <= mid && j_tmp <= j) {
		if (arr[i_tmp] <= arr[j_tmp]) {
			tmp[t] = arr[i_tmp];
			i_tmp++;
		}
		else {
			tmp[t] = arr[j_tmp];
			j_tmp++;
		}
		(*count)++;
		if (*count == save_count) {
			cout << tmp[t] << '\n';
		}
		t++;
	}
	while (i_tmp <= mid) {
		tmp[t] = arr[i_tmp];
		i_tmp++;
		(*count)++;
		if (*count == save_count) {
			cout << tmp[t] << '\n';
		}
		t++;
	}
	while (j_tmp <= j) {
		tmp[t] = arr[j_tmp];
		j_tmp++;
		(*count)++;
		if (*count == save_count) {
			cout << tmp[t] << '\n';
		}
		t++;
	}
	i_tmp = i;
	t = 1;
	while (i_tmp <= j) {
		arr[i_tmp] = tmp[t];
		i_tmp++;
		t++;
	}

}


int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	
	int size;
	int save_count;
	int count = 0;
	cin >> size >> save_count;
	int* arr = new int[size+1];
	arr[0] = 0;
	for (int i = 1; i <= size; i++) {
		cin >> arr[i];
	}
	mergesort(1, size, arr, save_count, &count);
	if (count < save_count) {
		cout << "-1" << '\n';
	}
	
}
