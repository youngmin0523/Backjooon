import java.io.*;
import java.util.*;

public class Main {
	static class Pos{
		int r, c;
		char color;
		public Pos(int r, int c, char color) {
			super();
			this.r = r;
			this.c = c;
			this.color = color;
		}
	}
	
	static int N, res1, res2, cnt;
	static char[][] map1, map2;
	static int visited1[][], visited2[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
 	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map1 = new char[N][N];
		map2 = new char[N][N];
		visited1 = new int[N][N];
		visited2 = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map1[i][j] = str.charAt(j);
				if(map1[i][j] == 'G') {
					map2[i][j] = 'R';
				}
				else {
					map2[i][j] = map1[i][j];
				}
			}
		}
		cnt = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				bfs(i, j, map1, visited1);
			}
		}
		System.out.print(cnt-1);
		cnt = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				bfs(i, j, map2, visited2);
			}
		}
		System.out.print(" " + (cnt-1));
	}
	static void bfs(int r, int c, char[][] map, int[][] visited){
		if(visited[r][c] != 0) return;
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(r, c, map[r][c]));
		visited[r][c] = cnt;
		
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			int nr, nc;
			for(int i = 0; i < 4; i++) {
				nr = tmp.r + dr[i];
				nc = tmp.c + dc[i];
				if(range(nr, nc) && map[nr][nc] == tmp.color && visited[nr][nc] == 0) {
					q.offer(new Pos(nr, nc, tmp.color));
					visited[nr][nc] = cnt;
				}
			}
		}
		cnt++;
	}
	static boolean range(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
