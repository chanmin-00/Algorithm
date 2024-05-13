#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace std;

int result = 0;
int n;
char gender[1001];

struct disjoint_set_data {
    struct nodetype {
        int parent;
        int depth;
    };
    vector<nodetype> U;

    disjoint_set_data(int n): U(n + 1) {} // 생성자에서 벡터의 크기를 초기화

    void makeset(int i) {
        U[i].parent = i;
        U[i].depth = 0;
    }
    void initial(int n) {
        for (int i = 1; i <= n; i++) {
            makeset(i);
        }
    }
    int find(int i) {
        if (U[i].parent != i)
            U[i].parent = find(U[i].parent);
        return U[i].parent;
    }
    void merge(int p, int q) {
        if (U[p].depth < U[q].depth)
            U[p].parent = q;
        else if (U[p].depth > U[q].depth)
            U[q].parent = p;
        else {
            U[p].depth++;
            U[q].parent = p;
        }
    }
};

class edge {
public:
    int vertex[2];
    int weight;
    int idx;

    edge(int idx = 0, int vertex1 = 0, int vertex2 = 0, int weight = 0) {
        this->idx = idx;
        this->vertex[0] = vertex1;
        this->vertex[1] = vertex2;
        this->weight = weight;
    }

    bool operator<(const edge& e) const {
        return this->weight < e.weight;
    }
};

void kruskal(int n, int m, vector<edge>& E, vector<edge>& F) {
    disjoint_set_data disjoint_set(n);
    sort(E.begin(), E.end()); // 모든 간선 집합을 정렬
    F.clear();
    disjoint_set.initial(n); // 초기화

    for (int count = 0; count < m && F.size() < n - 1; count++) {
        edge e = E[count];
        int i = e.vertex[0], j = e.vertex[1];
        int p = disjoint_set.find(i), q = disjoint_set.find(j);
        if (p != q && gender[i] != gender[j]) {
            disjoint_set.merge(p, q);
            F.push_back(e);
            result += e.weight;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int m;
    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        cin >> gender[i];
    }

    vector<edge> E, F; // 동적 크기 할당

    for (int i = 0; i < m; i++) {
        int u, v, d;
        cin >> u >> v >> d;
        E.push_back(edge(i, u, v, d));
    }

    kruskal(n, m, E, F);

    cout << (F.size() == n - 1 ? result : -1) << '\n';
}
