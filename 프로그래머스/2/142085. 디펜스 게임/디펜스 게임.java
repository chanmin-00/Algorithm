// n : 처음 가지고 있는 병사의 수
// k : 사용 가능한 무적권의 횟수
// 이거를 재귀호출로 풀어버리면 시간초과가 날 거 같다
// 계속해서 라운드를 지속하기 위해서는 병사 수가 0보다 작아질 때마다 무적권을 사용해서 병사 수를 늘리면 된다.
// 근데 늘릴 때는 가장 많은 병사 수를 살려내면 좋다.
// 그러면 가장 제일 좋은 값을 선택한다 -> 그러면 그리디로 푸는 것?

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        // 내림차순 우선순위 큐
        PriorityQueue<Integer> enemyQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0;i < enemy.length; i++) {
            n -= enemy[i];
            enemyQueue.offer(enemy[i]);
            
            if (n < 0 && k > 0 && !enemyQueue.isEmpty()) {
                n += enemyQueue.poll();
                k--;
            }
            
            if (n < 0) {
                answer = i;
                break;
            }
        }
        
        if (answer == 0) {
            answer = enemy.length;
        }
        
        return answer;
    }
}