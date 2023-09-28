#include <iostream>
#include <set>
#include <algorithm>

using namespace::std;

struct girl_group {
	string group_name;
	int human_cnt;
	set<string> human;
};

int binarySearch(const void* n_arr, const string x, const int n)
// 정렬된 배열에서 값을 찾는 이원탐색 알고리즘
{
	int left = 0, right = n - 1;
	struct girl_group* arr = (struct girl_group*)n_arr;

	while (left <= right)
	{
		int middle = (left + right) / 2;
		if (x < arr[middle].group_name) right = middle - 1;
		else if (x > arr[middle].group_name) left = middle + 1;
		else return middle;
	}
	return -1;
}


bool compare(const girl_group& group1, const girl_group& group2) {
	return group1.group_name < group2.group_name;
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int group_cnt, problem_cnt;
	int zero_one;
	string tmp;
	cin >> group_cnt >> problem_cnt;

	struct girl_group* group_arr = new struct girl_group[100];

	for (int i = 0; i < group_cnt; i++) {
		cin >> group_arr[i].group_name;
		cin >> group_arr[i].human_cnt;
		for (int j = 0; j < group_arr[i].human_cnt; j++) {
			cin >> tmp;
			group_arr[i].human.insert(tmp);
		}
	}

	sort(group_arr, group_arr + group_cnt, compare);
	// 이분탐색을 위한 정렬

	for (int i = 0; i < problem_cnt; i++) {
		cin >> tmp;
		cin >> zero_one;
		if (zero_one == 0) {
			int index = binarySearch(group_arr, tmp, group_cnt);
			if (index != -1)
			{
				for (set<string>::iterator iter = group_arr[index].human.begin(); iter != group_arr[index].human.end(); iter++) {
					cout << *iter << '\n';
				}
			}
		}
		else {
			for (int j = 0; j < group_cnt; j++) {
				if (group_arr[j].human.find(tmp) != group_arr[j].human.end())
				{
					cout << group_arr[j].group_name << '\n';
					break;
				}
			}
		}
	}
	return 0;;
}

