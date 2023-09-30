#include <iostream>
#include <algorithm>
#include <map>;

using namespace::std;

int count_macth_cloth(map<string, int>& tmp_map, int cloth_kind) {
	// 조합 : (각 의상의 개수 + 안 입는 경우 )를 다 곱해주고 마지막에 모두 다 안 입는 경우를 빼줌
	int ans = 1;
	for (map<string, int>::iterator iter = tmp_map.begin(); iter != tmp_map.end();)
	{
		ans *= (iter->second + 1);
        ++iter;
	}
	return ans-1;
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int testCase_count;
	int cloth_count;
	int cloth_kind_count;
	string cloth_name;
	string cloth_kind;

	cin >> testCase_count;
	for (int i = 0; i < testCase_count; i++) {
		map<string, int> cloth;
		cin >> cloth_count;
		cloth_kind_count = 0;
		for (int j = 0; j < cloth_count; j++) {
			cin >> cloth_name;
			cin >> cloth_kind;
			if (cloth.find(cloth_kind) == cloth.end()) {
				cloth.insert({ cloth_kind, 1 });
				cloth_kind_count++;
			}
			else {
			// 키 값이 이미 존재할 경우
			// map[key]는 value
				cloth[cloth_kind] += 1;
			}
		}
		// 맵 자료구조를 넘김으로써 조합계산
		cout << count_macth_cloth(cloth, cloth_kind_count) << '\n';
	}
}