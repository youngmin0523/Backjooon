import java.util.*;
import java.io.*;

public class Main {

	static class Pos {
		int r, c, time;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		public Pos(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	static int R, C;
	static char map[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0 , -1, 1};
	static Pos pos, end;
	static Queue<Pos> waters;
 	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		waters = new LinkedList<>();
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'D') {
					end = new Pos(i, j);
				}
				else if(map[i][j] == 'S') {
					pos = new Pos(i, j);
					map[i][j] = '.';
				}
				else if(map[i][j] == '*') {
					waters.offer(new Pos(i, j));
				}
			}
		}
		boolean visited[][] = new boolean[R][C];
		Queue<Pos> q = new LinkedList<>();
		q.offer(pos);
		visited[pos.r][pos.c] = true;
		
		Pos curr;
		int nr, nc;
		int time = -1;
		while(!q.isEmpty()) {
			curr = q.poll();
			
			if(time != curr.time) {
				time = curr.time;
				int size = waters.size();
				for(int i = 0; i < size; i++) {
					Pos water = waters.poll();
					for(int d = 0; d < 4; d++) {
						nr = water.r + dr[d];
						nc = water.c + dc[d];
						
						if(range(nr, nc) && map[nr][nc]=='.') {
							waters.offer(new Pos(nr, nc));
							map[nr][nc] = '*';
						}
					}
				}
			}
			
			for(int d = 0; d < 4; d++) {
				nr = curr.r + dr[d];
				nc = curr.c + dc[d];
				
				if(range(nr, nc) && !visited[nr][nc]) {
					if(map[nr][nc] == 'D') {
						System.out.println(curr.time+1);
						return;
					}
					else if(map[nr][nc] == '.') {
						q.offer(new Pos(nr, nc, curr.time+1));
						visited[nr][nc] = true;
					}
				}
			}
		}
		System.out.println("KAKTUS");
	}
	static boolean range(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
