import java.util.*;
import java.io.*;

// 가장 짧은 변환 과정을 찾아야 함
// word 집합을 한 번씩만 방문?

class Solution {
    static class Node {
        int depth;
        String str;
        
        public Node (int depth, String str) {
            this.depth = depth;
            this.str = str;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        HashSet<String> visited = new HashSet<>(); 

        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, begin));
        visited.add(begin);
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            String str = node.str;
            int cntDepth = node.depth;
            
            if (str.equals(target)) {
                return cntDepth;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (visited.contains(words[i])) {
                    continue;
                }
                
                int diffCnt = 0;
                
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) != words[i].charAt(j)) {
                        diffCnt++;
                    }        
                }
                
                if (diffCnt == 1) {
                    queue.offer(new Node(cntDepth + 1, words[i]));
                    visited.add(words[i]);
                }
            }
        }
        
        
        return answer;
    }
}