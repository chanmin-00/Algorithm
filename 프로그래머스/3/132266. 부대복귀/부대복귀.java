import java.util.*;
import java.io.*;

// 최단거리를 구하는 문제이다.
// n : 총 지역의 수
// roads : 두 지역을 왕복할 수 있는 길 정보, 왕복할 수 있으면 길의 길이는 n이다.
// sources : 출발지 정보
// destination : 목적지 정보
// 출발지 1을 경유해서 가는 경우
// 이차원 배열로 풀면 -> 메모리 초과
// 삼중반복문으로 풀게 되면 -> 시간 초과
// 결국 일차원 배열(또는 리스트), 이중반복문 내에서 풀어야 함,
// sources의 길이가 그렇게 길지 않으니까 sources를 출발지로 하는 bfs로 풀어볼까?
// 최단거리 문제면 bfs?
class Solution {
    
    static class Node {
        int v;
        int depth;
        
        public Node (int v, int depth) {
            this.v = v;
            this.depth = depth;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] tmpAnswer = new int[n + 1];
        boolean[] visited;
        
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0;i < roads.length; i++) {
            for (int j = 0; j < 2; j++) {
                int area1 = roads[i][0];
                int area2 = roads[i][1];
                
                list.get(area1).add(area2);
                list.get(area2).add(area1);
            }
        }
        
        // 각 source마다 bfs를 돌리기 때문에 시간초과가 발생한다.
        // 이걸 방지하기 위해 목적지에서 bfs를 한 번만 돌리면 된다.
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[n + 1];
        boolean flag = false;
            
        queue.offer(new Node(destination, 0));
        visited[destination] = true;
            
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentDepth = current.depth;
            int currentV = current.v;
            tmpAnswer[currentV] = currentDepth;
                
            List<Integer> neighbor = list.get(currentV);

            for (int j = 0;j < neighbor.size(); j++) {
               int v = neighbor.get(j);
                    
               if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(new Node(v, currentDepth + 1));
               }
            }
        }
            
        for (int i = 0; i < sources.length; i++) {
            int start = sources[i];
            if (tmpAnswer[start] != 0) {
                answer[i] = tmpAnswer[start];
            }
            else {
                if (sources[i] == destination) {
                    answer[i] = 0;
                }
                else {
                    answer[i] = -1;
                }
            }
        }
        
        return answer;
    }
}