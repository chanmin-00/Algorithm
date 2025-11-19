import java.io.*;
import java.util.*;

// 최단거리니까 bfs로 풀어보자!
// 벽을 부술 수 있어서 여러 가지 경우를 둬야 한다.
// 벽을 지나쳐서 오는 경우가 있고, 벽을 부수고 오는 경우가 있다.
// 현재 위치까지 벽을 부수고 온 횟수가 같으면 그거는 먼저 온 쪽이 더 빠른거
// 벽을 현재까지 부순 횟수가 다르기 때문에 이후에 부술수 있는 횟수도 다름. 그거에 대한 속도 차이가 날 것임
// 그렇기 때문에 그거에 대한 차이를 둬야 함
public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static String[] input;

    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][][] visited; // 3차원으로 변경
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Node {
       int i;
       int j;
       int remainCrashCount;
       int depth;

       public Node(int i, int j, int remainCrashCount, int depth) {
          this.i = i;
          this.j = j;
          this.remainCrashCount = remainCrashCount;
          this.depth = depth;
       }
    }

    public static void main(String[] args) throws IOException {

       input = reader.readLine().split(" ");

       N = Integer.parseInt(input[0]);
       M = Integer.parseInt(input[1]);
       K = Integer.parseInt(input[2]);

       map = new int[N + 1][M + 1];
       visited = new boolean[N + 1][M + 1][K + 1]; // 3차원 배열

       for (int i = 1; i <= N; i++) {
          String str = reader.readLine();

          for (int j = 1; j <= M; j++) {
             map[i][j] = Integer.parseInt(str.charAt(j - 1) + "");
          }
       }

       Queue<Node> queue = new LinkedList<Node>();
       queue.offer(new Node(1, 1, K, 1));
       visited[1][1][K] = true; // 시작점 방문 체크

       while (!queue.isEmpty()) {
          Node node = queue.poll();

          if (node.i == N && node.j == M) {
             System.out.println(node.depth);
             return;
          }

          for (int i = 0; i < 4; i++) {
             int newI = node.i + dx[i];
             int newJ = node.j + dy[i];

             if (newI >= 1 && newI <= N && newJ >= 1 && newJ <= M) {
                if (map[newI][newJ] == 1) { // 벽인 경우
                   if (node.remainCrashCount > 0 && !visited[newI][newJ][node.remainCrashCount - 1]) {
                      queue.offer(new Node(newI, newJ, node.remainCrashCount - 1, node.depth + 1));
                      visited[newI][newJ][node.remainCrashCount - 1] = true;
                   }
                } else { // 빈 칸인 경우
                   if (!visited[newI][newJ][node.remainCrashCount]) {
                      queue.offer(new Node(newI, newJ, node.remainCrashCount, node.depth + 1));
                      visited[newI][newJ][node.remainCrashCount] = true;
                   }
                }
             }
          }
       }

       System.out.println(-1);
    }
}