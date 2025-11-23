import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;
	static int R = 0;
	static int C = 0;
	static String[][] arr;
	static boolean[][] visited;
	
	static int vCnt = 0;
	static int oCnt = 0;
	
	static int totalVCnt = 0;
	static int totalOCnt = 0;
	
	static int[] dx = new int[] {-1, 0, 1, 0};
	static int[] dy = new int[] {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		input = reader.readLine().split(" ");
		
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		arr = new String[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0;i < R ;i++) {
			String str = reader.readLine();
			
			for (int j = 0;j < C; j++) {
				arr[i][j] = str.charAt(j) + "";
			}
		}
		
		for (int i = 0;i < R ;i++) {
			for (int j = 0;j < C; j++) {
				
				vCnt = 0;
				oCnt = 0;
				
				if (visited[i][j] == false && !arr[i][j].equals("#")) {
					dfs(i, j);
				}
				
				if (vCnt >= oCnt) {
					totalVCnt += vCnt;
				}
				else {
					totalOCnt += oCnt;
				}
			}
		}
		
		System.out.println(totalOCnt + " " + totalVCnt);
		
	}
	
	// 일단 방문이 가능한 경우에만 dfs를 호출
	public static void dfs(int i, int j) {
		visited[i][j] = true;
		
		if (arr[i][j].equals("v")) {
			vCnt++;
		}
		else if (arr[i][j].equals("o")) {
			oCnt++;
		}
		
		for (int index = 0; index < 4; index++) {
			int newI = i + dx[index];
			int newJ = j + dy[index];
			
			if (newI > -1 && newI < R && newJ > -1  && newJ < C) {
				if (visited[newI][newJ] == false && !arr[newI][newJ].equals("#")) {
					dfs(newI, newJ);
				}
			}
		}
		
	}

}
