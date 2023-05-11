import java.io.*;
import java.util.*;
 
public class Main {
	
	static class Pos{
		int r, c, cnt;
		
		Pos(int r, int c, int cnt){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int N, M, min;
	static int map[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		min = Integer.MAX_VALUE;
		
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j-1)-'0';
			}
		}
		bfs();
		System.out.println(min+1);
	}
	static void bfs() {
		Queue<Pos> q = new ArrayDeque<>();
		boolean visited[][] = new boolean[N+1][M+1];
		q.offer(new Pos(1, 1, 0));
		
		Pos curr;
		while(!q.isEmpty()) {
			curr = q.poll();
			if(curr.r == N && curr.c == M) {
				min = Math.min(min, curr.cnt);
			}
			
			int nr, nc;
			for(int d = 0; d < 4; d++) {
				nr = curr.r + dr[d];
				nc = curr.c + dc[d];
				
				if(range(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.offer(new Pos(nr, nc, curr.cnt+1));
				}
			}
		}
		
		
	}
	static boolean range(int r, int c) {
		return r >= 1 && r <= N && c >= 1 && c <= M;
	}
}