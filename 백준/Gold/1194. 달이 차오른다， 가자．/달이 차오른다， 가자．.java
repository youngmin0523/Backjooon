import java.util.*;
import java.io.*;

public class Main {

	static class Pos {
		int r, c, key, cnt;

		public Pos(int r, int c, int key, int cnt) {
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}
	}
	
	static int N, M, res = -1;
	static char maze[][];
	static Pos start;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static boolean visited[][][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][M];
		visited = new boolean[64][N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j  = 0; j < M; j++) {
				maze[i][j] = str.charAt(j);
				if(maze[i][j] == '0') {
					start = new Pos(i, j, 0, 0);
					maze[i][j] = '.';
				}
			}
		}
		bfs();
		System.out.println(res);
	}
	static void bfs() {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(start);
		visited[start.key][start.r][start.c] = true;
		
		Pos curr;
		int nr, nc;
		while(!q.isEmpty()) {
			curr = q.poll();
			for(int d = 0; d < 4; d++) {
				nr = curr.r + dr[d];
				nc = curr.c + dc[d];
				
				if(range(nr, nc) && !visited[curr.key][nr][nc]) {
					if(maze[nr][nc] == '1') {
						res = curr.cnt + 1;
						return;
					}
					else if(maze[nr][nc] == '.') {
						q.offer(new Pos(nr, nc, curr.key, curr.cnt+1));
						visited[curr.key][nr][nc] = true;
					}
					else if(maze[nr][nc] >= 'a' && maze[nr][nc] <= 'f') {
						int key = curr.key | 1<<(maze[nr][nc]-'a');
						q.offer(new Pos(nr, nc, key, curr.cnt+1));
						visited[curr.key][nr][nc] = true;
						visited[key][nr][nc] = true;
					}
					else if(maze[nr][nc] >= 'A' && maze[nr][nc] <= 'F') {
						if(((1<<(maze[nr][nc]-'A')) & curr.key) > 0) {
							q.offer(new Pos(nr, nc, curr.key, curr.cnt+1));
							visited[curr.key][curr.r][curr.c] = true;
						}
					}
				}
			}
		}
	}
	static boolean range(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
