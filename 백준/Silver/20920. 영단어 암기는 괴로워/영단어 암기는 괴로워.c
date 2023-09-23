#include<stdio.h>
#include<string.h>
#include<stdlib.h>

typedef struct _INFO{
	char name[11];
	int count;
	int len;
}INFO;

int compare(INFO* a, INFO* b, int flag) {
	int i = 0;
	if (flag) {
		if (a->len > b->len) return 1;
		else if (a->len < b->len) return 0;
		
		while (a->name[i]) {
			if (a->name[i] < b->name[i]) return 1;
			else if (a->name[i] > b->name[i]) return 0;
			i++;
		}
		return 1;
	}
	if (a->count >= b->count) return 1;
	return 0;
}

void merge_sort(INFO a[], INFO sorted[], int m, int mid, int n, int flag) {
	int i = m;
	int j = mid + 1;
	int k = m;

	while (i <= mid && j <= n) {
		if (compare(&a[i], &a[j], flag)) {
			sorted[k] = a[i];
			i++;
		}
		else {
			sorted[k] = a[j];
			j++;
		}
		k++;
	}

	if (i > mid) {
		for (int t = j; t <= n; t++) {
			sorted[k] = a[t];
			k++;
		}
	}
	else {
		for (int t = i; t <= mid; t++) {
			sorted[k] = a[t];
			k++;
		}
	}

	for (int t = m; t <= n; t++) {
		a[t] = sorted[t];
		sorted[t] = a[t];
	}
	return;
}

void merge(INFO a[], INFO sorted[], int m, int n, int flag) {
	if (m < n) {
		int mid = (m + n) / 2;
		merge(a, sorted, m, mid, flag);
		merge(a, sorted, mid + 1, n, flag);
		merge_sort(a, sorted, m, mid, n, flag);
	}
	return;
}

int main() {
	int n, m, num = 0;
	char temp[11];
	scanf("%d%d", &n, &m);
	
	INFO* info = (INFO*)malloc(sizeof(INFO) * n);
	INFO* sorted = (INFO*)malloc(sizeof(INFO) * n);

	for (int i = 0; i < n; i++) {
		scanf("%s", temp);
		int len = strlen(temp);
		if (len >= m) {
			strcpy(info[num].name, temp);
			info[num].len = len;
			info[num].count = 1;
			sorted[num] = info[num];
			num++;
		}
	}
	merge(info, sorted, 0, n - 1, 1);

	int i = 0, next = 1, sortnum = 0; 
	while (i < num) {
		if (strcmp(sorted[i].name, sorted[next].name)) {
			info[sortnum++] = sorted[i];
			i = next;
			next = i + 1;
			continue;
		}
		else sorted[i].count++;
		next++;
	}
	merge(info, sorted, 0, sortnum - 1, 0);
	for (int i = 0; i < sortnum; i++) {
		printf("%s\n", info[i].name);
	}
    	free(info);
    	free(sorted);
}