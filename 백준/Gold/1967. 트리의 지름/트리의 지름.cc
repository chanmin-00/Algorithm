#include <iostream>
#include <algorithm>
#include <vector>

using namespace::std;

// 트리의 지름 구하기 문제
// 트리의 중요한 특징 :  어떤 두 노드를 선택해도 둘 사이에 경로가 항상 하나만 존재
// 특정 정점을 선택 후, 가장 거리가 먼 정점을 선택할 경우 선택된 정점은 원의 선분 위에 존재
// 원의 선분 위에 존재하는 정점 선택 후, 그 정점으로부터 가장 거리가 먼 정점과의 거리가 원의 지름

vector<pair<int, int>> arr[10001];
bool visited[10001];
void dfs(int index, int sum, int& max, int& maxV);

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n; // 노드의 개수
	int nodeIndex1, nodeIndex2; // 노드 인덱스
	int value; // 간선의 가중치
	int max = -1; // 최장 경로 길이 저장 값
	int maxV; // 최장 경로 노드 인덱스 값
	
	cin >> n;

	for (int i = 1; i < n; i++) {
		cin >> nodeIndex1 >> nodeIndex2 >> value;
		// 어떤 노드에서 다른 노드로 가기 위해 쌍방으로 값 저장
		arr[nodeIndex1].push_back({ nodeIndex2, value }); 
		arr[nodeIndex2].push_back({ nodeIndex1, value });
	}

	fill(visited, visited + 10001, false);
	dfs(1, 0, max, maxV);
	
	max = -1;
	fill(visited, visited + 10001, false);
	dfs(maxV, 0, max, maxV);

	cout << max << "\n";
}

void dfs(int index, int sum, int& max, int& maxV) {
	
	if (visited[index] == false) { // 방문한것을 다시 방문하게 되면 무한 루프에 걸리게 되어 seg fault 오류 발생
		visited[index] = true;
		if (sum > max) {
			max = sum;
			maxV = index;
		}
		for (int i = 0; i < arr[index].size(); i++) {
			dfs(arr[index].at(i).first, sum + arr[index].at(i).second, max, maxV);
		}
	}
}