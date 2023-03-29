import java.util.*;
import java.io.*;

public class Main {
	
	static class Pos {
		int r, c, cnt, k;

		public Pos(int r, int c, int cnt, int k) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
	}
	
	static int K, H, W, map[][];
	static int[] dr_m = {-1, 1, 0, 0};
	static int[] dc_m = {0, 0, -1, 1};
	static int[] dr_h = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc_h = {-2, -1, 1, 2, 2, 1, -1, -2};
	static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine().trim(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H+1][W+1];
		visited = new boolean[K+1][H+1][W+1];
		
		for(int r = 1; r <= H; r++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int c = 1; c <= W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}
	static int bfs() {
		Queue<Pos> q = new ArrayDeque<>();
		
		q.offer(new Pos(1, 1, 0, 0));
		visited[0][1][1] = true;
		
		Pos curr = null;
		int nr, nc;
		while(!q.isEmpty()) {
			curr = q.poll();
			if(curr.r == H && curr.c == W) {
				return curr.cnt;
			}
			
			for(int d = 0; d < 4; d++) {
				nr = curr.r+dr_m[d];
				nc = curr.c+dc_m[d];
				
				if(range(nr, nc) && !visited[curr.k][nr][nc] && map[nr][nc] == 0) {
					q.offer(new Pos(nr, nc, curr.cnt+1, curr.k));
					visited[curr.k][nr][nc] = true;
				}
			}
			if(curr.k >= K) {
				continue;
			}
			for(int d = 0; d < 8; d++) {
				nr = curr.r+dr_h[d];
				nc = curr.c+dc_h[d];
				
				if(range(nr, nc) && !visited[curr.k+1][nr][nc] && map[nr][nc] == 0) {
					q.offer(new Pos(nr, nc, curr.cnt+1, curr.k+1));
					visited[curr.k+1][nr][nc] = true;
				}
			}
		}
		return -1;
	}
	static boolean range(int r, int c) {
		return r >= 1 && r <= H && c >= 1 && c <= W;
	}
}
