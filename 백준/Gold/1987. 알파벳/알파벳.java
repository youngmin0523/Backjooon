import java.io.*;
import java.util.*;

public class Main {
	static int R, C, max;
	static char[][] board;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		dfs(0, 0, 1, 0);
		System.out.println(max);
	}	
	static void dfs(int r, int c, int cnt, int mask) {
		if(cnt > max) {
			max = cnt;
		}
		mask = mask | (1<<(board[r][c]-'A'));
		
		int nr, nc;
		for(int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(range(nr, nc) && (mask & (1<<(board[nr][nc]-'A'))) == 0) {
				dfs(nr, nc, cnt+1, mask);
			}
		}
	}
	static boolean range(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
