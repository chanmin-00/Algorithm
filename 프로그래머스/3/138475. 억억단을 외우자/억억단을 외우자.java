import java.util.*;
import java.io.*;

// 완전한 이중 반복문으로 하면 시간초과가 난다.
// 좀 시간을 줄일 수 있는 이중 반복문을 사용해야 한다.
// 모든 것을 다 확인하는 이중 반복문이 아니라 점프를 띄면서 확인하는 이중반복문으로 시간초과를 줄일수 있다.

class Solution {
    
    static class Node {
        int num;
        int cnt;
        
        public Node (int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] arr = new int[e + 1];
        
        for (int i = 1; i <= e; i++) {
            for (int j = i ; j <= e; j+= i) {
                arr[j] = arr[j] + 1; // 약수의 개수를 기록
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
           if (n1.cnt != n2.cnt) {
               return n2.cnt - n1.cnt;
           }
           else {
               return n1.num - n2.num;
           }
        });
        
        for (int i = e; i >= 1 ; i--) {       
            pq.offer(new Node(i, arr[i]));
            
            arr[i] = pq.peek().num;
            // System.out.println(pq.peek().num);
        }
        
        for (int i = 0; i < starts.length; i++) {
            answer[i] = arr[starts[i]];
        }

        return answer;
    }
}