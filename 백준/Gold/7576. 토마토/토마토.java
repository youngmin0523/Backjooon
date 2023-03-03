import java.io.*;
import java.util.*;

public class Main {
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, box[][], rowTomato, day;
	static Queue<Pos> q = new LinkedList<>();
	static boolean visited[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		visited = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
				if(box[r][c] == 1) {
					q.offer(new Pos(r, c));
					visited[r][c] = true;
				}
				if(box[r][c] == 0) {
					rowTomato++;
				}
			}
		}
		bfs();
		System.out.println(rowTomato>0?-1:day);
	}
	static void bfs() {
		Pos current;
		int nr, nc;
		while(!q.isEmpty() && rowTomato > 0) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				current = q.poll();
				for(int d = 0; d < 4; d++) {
					nr = current.r + dr[d];
					nc = current.c + dc[d];
					if(range(nr, nc) && !visited[nr][nc] && box[nr][nc] == 0) {
						box[nr][nc] = 1;
						rowTomato--;
						q.offer(new Pos(nr, nc));
						visited[nr][nc] = true;
					}
				}
			}
			day++;
		}
	}
	static boolean range(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
