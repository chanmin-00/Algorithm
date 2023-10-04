#include <iostream>
#include <algorithm>
#include <map>

using namespace::std;

struct study_human {
	string school_code;
	int index;
};

bool compare(const study_human& group1, const study_human& group2) {
	return group1.index < group2.index;
}

int main(void)
{
	//ios_base::sync_with_stdio(0);
	// cin.tie(0);

	int pos_count;
	int total;
	string school_code;
	int index = 1;
	map<string, int> study_pos;

	cin >> pos_count >> total;
	for (int i = 0; i < total; i++) {
		cin >> school_code;
		if (study_pos.find(school_code) == study_pos.end()) {
			study_pos.insert({ school_code, index });
		}
		else {
			study_pos[school_code] = index;
		}
		index++;
	}

	struct study_human* human_arr = new struct study_human[total];
	map<string, int>::iterator iter;
	int i = 0;
	for (iter = study_pos.begin(); iter != study_pos.end(); iter++) {
		human_arr[i].school_code = iter->first;
		human_arr[i].index = iter->second;
		i++;
	}
	sort(human_arr, human_arr + i, compare);
	if (pos_count <= i) {
		for (int k = 0; k < pos_count; k++) {
			cout << human_arr[k].school_code << '\n';
		}
	}
	else {
		for (int j = 0; j < i; j++) {
			cout << human_arr[j].school_code << '\n';
		}
	}
}