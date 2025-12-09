import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int len = targets.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> {
            if (a1[0] != a2[0]) {
                return a1[0] - a2[0];
            }
            else {
                return a1[1] - a2[1];
            }
        });
            
        for (int i = 0;i <len;i++) {
            queue.offer(targets[i]);
        }
        
        while (!queue.isEmpty()) {
            int[] first = queue.poll();
            int end = first[1];
            
            while (true) {
                if (!queue.isEmpty() && end > queue.peek()[0]) {
                    if (end > queue.peek()[1]) {
                        end = queue.peek()[1];
                    }
                    queue.poll();
                }
                else {
                    break;
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}