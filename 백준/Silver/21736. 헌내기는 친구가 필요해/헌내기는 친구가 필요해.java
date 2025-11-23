import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;
	
	static int N;
	static int M;
	static String[][] arr; 
	static boolean[][] visited;
	
	static int[] dx = new int[] {-1, 0, 1, 0};
	static int[] dy = new int[] {0, -1, 0, 1};
	
	static int peopleCnt = 0;
	
	public static void main(String[] args) throws Exception {
		input = reader.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		arr = new String[N][M];
		visited = new boolean[N][M];
		
		int startI = 0;
		int startJ = 0;
		
		for (int i = 0;i < N ; i++) {
			String str = reader.readLine();
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) + "";
				
				if (arr[i][j].equals("I")) {
					startI = i;
					startJ = j;
				}
			}
		}
		
		visited[startI][startJ] = true;
		
		dfs(startI, startJ);
		
		if (peopleCnt == 0) {
			System.out.println("TT");
            return;
		}
		
		System.out.println(peopleCnt);
		
	}
	
	public static void dfs(int i, int j) {
		if (arr[i][j].equals("X")) {
			return;
		}
		
		
		if (arr[i][j].equals("P")) {
			peopleCnt++;
			
		}
	
			
			for (int index = 0; index < 4; index++) {
				int newI = i + dx[index];
				int newJ = j + dy[index];
				
				if (newI > -1 && newI < N && newJ > - 1 && newJ < M) {
					if (visited[newI][newJ] == false) {
						visited[newI][newJ] = true;
						
						dfs(newI, newJ);
					}
				}
			}
	
		
		return;
		
	}
	

}
