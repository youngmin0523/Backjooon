import java.io.*;
import java.util.*;

public class Main {
	private static class Shark {
		int r, c, size, eatCnt;

		public Shark(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}
	private static class Pos implements Comparable<Pos> {
		int r, c, time;

		public Pos(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Pos o) {
			if(this.time == o.time) {
				if(this.r == o.r) {
					return this.c-o.c;
				}
				return this.r-o.r;
			}
			return this.time-o.time;
		}
		
	}
	
	private static int N, map[][], res;
	private static Shark shark;
	private static int[] dr = {-1, 0, 0, 1};
	private static int[] dc = {0, -1, 1, 0};
	private static int[] fishCnt = new int[7];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) continue;
				if(map[i][j] == 9) {
					shark = new Shark(i, j, 2);
					map[i][j] = 0;
				}
				else {
					fishCnt[map[i][j]]++;
				}
			}
		}
		while(true) {
			int cnt = 0;
			for(int i = 1; i < Math.min(shark.size, 7); i++) {
				cnt += fishCnt[i];
			}
			if(cnt == 0) break;
			int preCnt = shark.eatCnt;
			bfs();
			if(preCnt == shark.eatCnt) {
				break;
			}
		}
		System.out.println(res);
	}
	private static void bfs() {
		boolean[][] visited = new boolean[N][N];
		Queue<Pos> q = new PriorityQueue<>();
		q.add(new Pos(shark.r, shark.c, 0));
		visited[shark.r][shark.c] = true;
		
		Pos current;
		int nr, nc;
		while(!q.isEmpty()) {
			current = q.poll();
			if(map[current.r][current.c] > shark.size) continue;
			if(map[current.r][current.c] > 0 
					&& map[current.r][current.c] < shark.size) {
				res += current.time;
				shark.r = current.r;
				shark.c = current.c;
				shark.eatCnt++;
				if(shark.eatCnt == shark.size) {
					shark.size++;
					shark.eatCnt = 0;
				}
				fishCnt[map[current.r][current.c]]--;
				map[current.r][current.c] = 0;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				nr = current.r + dr[d];
				nc = current.c + dc[d];
				if(range(nr, nc) && !visited[nr][nc]) {
					q.offer(new Pos(nr, nc, current.time+1));
					visited[nr][nc] = true;
				}
			}
		}
	}
	private static boolean range(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
