#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N, K;
    cin >> N >> K;

    vector<int> heights(N);
    for (int i = 0; i < N; i++) {
        cin >> heights[i];
    }

    sort(heights.begin(), heights.end());

    vector<int> diffs(N-1);
    for (int i = 0; i < N-1; i++) {
        diffs[i] = heights[i+1] - heights[i];
    }

    sort(diffs.begin(), diffs.end(), greater<int>());

    int cost = heights[N-1] - heights[0];
    for (int i = 0; i < K-1; i++) {
        cost -= diffs[i];
    }

    cout << cost << endl;

    return 0;
}