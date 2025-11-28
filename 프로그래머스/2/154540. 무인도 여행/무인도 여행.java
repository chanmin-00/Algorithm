import java.util.*;
import java.io.*;

class Solution {
    
    static int R;
    static int C;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static String[][] arr;
    static int sum = 0;
    static Queue<Integer> result = new PriorityQueue<>();
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        R = maps.length;
        C = maps[0].length();
        
        arr = new String[R + 1][C + 1];
        visited = new boolean[R + 1][C + 1];
        
        for (int i = 1;i <= R; i++) {
            for (int j = 1;j <= C; j++) {
                arr[i][j] = maps[i - 1].charAt(j - 1) + "";
            }
        }
        
        for (int i = 1;i <= R; i++) {
            for (int j = 1;j <= C; j++) {
                if (visited[i][j] == false && !arr[i][j].equals("X")) {
                    sum = Integer.parseInt(arr[i][j]);
                    visited[i][j] = true;
                    
                    dfs(i, j);
                    
                    result.offer(sum);
                   // System.out.println(sum);
                }
            }
        }
        
        if (result.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        }
        else {
            answer = new int[result.size()];
            int index = 0;
            while (!result.isEmpty()) {
                answer[index] = result.poll();
                index++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int i, int j) {
        
        for (int index = 0;index < 4; index++) {
            int newI = i + dx[index];
            int newJ = j + dy[index];
            
            
            if (newI >= 1 && newI <= R && newJ >= 1 && newJ <=C) {
                if (visited[newI][newJ] == false && !arr[newI][newJ].equals("X"))  {
                    visited[newI][newJ] = true;
                    
                    int newValue = Integer.parseInt(arr[newI][newJ]);
                    sum += newValue;
                    
                    dfs(newI, newJ);
                }
            }
        }
    }
}