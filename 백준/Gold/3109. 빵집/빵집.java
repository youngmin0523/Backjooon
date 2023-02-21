import java.io.*;
import java.util.*;

public class Main {
	static int R, C, cnt;
	static char map[][];
	static int[] dr = {-1, 0, 1};
	static boolean flag, visited[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);
		}
		System.out.println(cnt);
	}
	static void dfs(int r, int c) {
		if(c == C-1) {
			cnt++;
			flag = true;
			return;
		}
		
		int nr, nc;
		for(int i = 0; i < 3; i++) {
			nr = r + dr[i];
			nc = c + 1;
			if(!range(nr, nc) || map[nr][nc] == 'x' || visited[nr][nc]) {
				continue;
			}
			visited[nr][nc] = true;
			dfs(nr, nc);
			if(flag) return;
		}
	}
	static boolean range(int r, int c) {
		if(r < 0 || r >= R || c < 0 || c >= C) return false;
		return true;
	}
}
