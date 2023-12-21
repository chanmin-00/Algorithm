#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N, A, B, C;
    cin >> N >> A >> B >> C;

    vector<int> toppingCalories(N);
    for (int i = 0; i < N; ++i) {
        cin >> toppingCalories[i];
    }

    // 토핑 열량을 내림차순으로 정렬
    sort(toppingCalories.rbegin(), toppingCalories.rend());

    // 최고의 피자의 1원 당 열량 계산
    int totalCalories = C;
    int totalPrice = A;

    for (int i = 0; i < N; ++i) {
        int currentCalories = totalCalories + toppingCalories[i];
        int currentPrice = totalPrice + B;

        if (static_cast<double>(currentCalories) / currentPrice > static_cast<double>(totalCalories) / totalPrice) {
            totalCalories = currentCalories;
            totalPrice = currentPrice;
        } else {
            // 그리디적으로 선택할 때, 더 이상 향상이 없다면 중단
            break;
        }
    }

    // 결과 출력
    int result = totalCalories / totalPrice; // 정수 값으로 출력
    cout << result << endl;

    return 0;
}