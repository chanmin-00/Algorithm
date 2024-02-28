#include <iostream>
#include <algorithm>
#include <queue>

using namespace::std;

void DFS(int n, int v, int*& visited);
void BFS(int n, int v, int*& visited);
int arr[1001][1001] = { 0 };

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n; // 정점의 개수
	int m; // 간선의 개수
	int v; // 탐색을 시작할 정점의 번호 v

	cin >> n >> m >> v;

	for (int i = 0; i < m; i++) { // 간선 입력 받기
		int v1, v2;

		cin >> v1 >> v2;
		arr[v1][v2] = 1;
		arr[v2][v1] = 1;
	}

	/*
	DFS
	*/
	int* visited = new int[1001];
	for (int i = 0; i < 1001; i++) {
		visited[i] = 0;
	}
	visited[v] = 1;
	DFS(n, v, visited);
	
	/*
	BFS
	*/
	for (int i = 0; i < 1001; i++) {
		visited[i] = 0;
	}
	visited[v] = 1;
	BFS(n, v, visited);
	
}

void DFS(int n, int v, int*& visited) {
	
	cout << v << "\n";
	for (int i = 1; i <= n; i++) {
		if (arr[v][i] == 1 && visited[i] == 0) { // 간선이 존재하고, i를 방문하지 않은 경우
			visited[i] = 1;
			DFS(n, i, visited);
		}
	}
}

void BFS(int n, int v, int*& visited) {

	queue<int> bfs;
	
	bfs.push(v);
	
	while (!bfs.empty()) {
		int front = bfs.front();
		cout << front << endl; // 큐의 가장 앞쪽에 있는것 출력

		bfs.pop();

		for (int i = 1; i <= n; i++) {
			if (arr[front][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				bfs.push(i); // 정점과 연결된 모든 정점 큐에 삽입
			}
		}
	}

}