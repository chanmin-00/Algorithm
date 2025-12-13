// 최단거리
// 간선은 양방향
import java.io.*;
import java.util.*;

class Solution {
    
    static class Node {
        int v;
        int depth;
        
        public Node (int v, int depth) {
            this.v = v;
            this.depth = depth;
        }
    }
        
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0];
            int v2 = edge[i][1];
            
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        
        Queue<Node> queue = new LinkedList<>();
        int max = 0;
        queue.offer(new Node(1, 1));
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int currentDepth = current.depth;
            int currentV =current.v;
            
            if (currentDepth > max) {
                answer = 1;
                max = currentDepth;
            }
            else if (currentDepth == max) {
                answer++;
            }
            
            List<Integer> neighbor = list.get(currentV);
            
            for (int i = 0; i < neighbor.size(); i++) {
                int nextV = neighbor.get(i);
                
                if (!visited[nextV]) {
                    queue.offer(new Node(nextV, currentDepth + 1));
                    visited[nextV] = true;
                }
            }
            
        }
        
        return answer;
    }
}