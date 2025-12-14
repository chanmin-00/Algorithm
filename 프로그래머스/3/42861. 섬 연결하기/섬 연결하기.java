import java.util.*;
import java.io.*;

// 최소 신장 트리 문제
// 모든 트리를 최소로 연결하는 문제
// 연결할 수 없는 섬은 주어지지 않기 때문에 이 문제는 트리 문제라 파악할 수 있다.
// 트리는 사이클을 만들면 안된다.
// 결과적으로 최종 연결되었을 때 간선의 수가 n- 1이어야 한다.
// 최소 신장 트리는 크루스칼 알고리즘을 통해서 union-find 적용
// 간선이 n-1개인 하나의 union으로 만들어야 한다.

class Solution {
    
    int[] parent;
    
    // 루트 찾기
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        
        // x의 부모는 parent[x]인데 다시 parent[x]의 부모를 찾아서 반환해줌
        return parent[x] = find(parent[x]);
    }
    
    // 같은 집합으로 합치기
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        // 최상단 부모가 같으면 같은 집합
        if (rootX == rootY) {
            return false;
        }
        
        // 부모가 다르면 합치기
        parent[rootY] = rootX;
        return true;
        
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        
        for (int i = 0 ;i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);
        
        int cnt = 0;
        for (int[] cost : costs) {
            
            // 사이클이 아니면 합치기
            if (union(cost[0], cost[1])) {
                answer += cost[2];
                cnt++;
                if (cnt == n - 1) break;
            }
        }
        
        return answer;
    }
}