import java.util.*;
import java.io.*;

// 가장 맵지 않은 것의 스코빌 지수가 K보다 높아지면 문제의 조건을 충족시킬 수 있다.

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        long longK = (long) K;
        PriorityQueue<Long> heap = new PriorityQueue<>();
        
        for (int i = 0;i < scoville.length; i++) {
            heap.offer((long) scoville[i]);
        }
        
        while (true) {
            long min1 = 0;
            long min2 = 0;
            
            if (heap.peek() >= K) {
                break;
            }
            
            if (heap.size() >= 2) {
                min1 = heap.poll();
                min2 = heap.poll();
                heap.offer(min1 + 2 * min2);
                
                answer++;
            }
            else {
                answer = -1;
                break;
            }
            
            
        }
        
        return answer;
    }
}