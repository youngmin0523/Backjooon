import java.io.*;
import java.util.*;

public class Main {
	static class Pos {
		int r, c, d;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public Pos(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	static int N, M, D, map[][], tmpMap[][], res;
	static List<int[]> archers;
	static List<Pos> enemys;
	static int[] dr = {0,-1, 0};
	static int[] dc = {-1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		archers = new ArrayList<>();
		enemys = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				if(map[i][j] == 1) {
//					enemys.add(new Pos(i, j));
//				}
			}
		}
		comb(0, 0, new int[3]);
		
		for(int i = 0; i < archers.size(); i++) {
			int cnt = 0;
			tmpMap = new int[N+1][M];
			for(int j = 0; j < N+1; j++) {
				tmpMap[j] = Arrays.copyOf(map[j], M);
			}
			
			for(int j = N; j > 0; j--) {
				for(int k = 0; k < 3; k++) {
					Pos enemy = bfs(new Pos(j-1, archers.get(i)[k], 1));
					if(enemy != null) {
						enemys.add(enemy);
					}
				}
				for(int k = 0; k < enemys.size(); k++) {
					if(tmpMap[enemys.get(k).r][enemys.get(k).c] == 1) {
						tmpMap[enemys.get(k).r][enemys.get(k).c] = 0;
						cnt++;
					}
				}
				enemys.clear();
			}
			
			if(cnt > res) {
				res = cnt;
			}
		}
		System.out.println(res);
	}
	static Pos bfs(Pos current) {
		Queue<Pos> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		q.offer(current);
		visited[current.r][current.c] = true;
		
		Pos tmp;
		int nr, nc, d;
		while(!q.isEmpty()) {
			tmp = q.poll();
			if(tmp.d > D) {
				break;
			}
			if(tmpMap[tmp.r][tmp.c] == 1) {
				return new Pos(tmp.r, tmp.c);
			}
			for(int i = 0; i < 3; i++) {
				nr = tmp.r + dr[i];
				nc = tmp.c + dc[i];
				d = tmp.d + 1;
				if(range(nr, nc) && !visited[nr][nc] && d <= D) {
					q.offer(new Pos(nr, nc, tmp.d+1));
					visited[nr][nc] = true;
				}
			}
		}
		return null;
	}
	static boolean range(int r, int c) {
		return r >= 0 && c >= 0 && c < M;
	}
	static void comb(int cnt, int start, int[] arr) {
		if(cnt == 3) {
			archers.add(new int[] {arr[0], arr[1], arr[2]});
			return;
		}
		for(int i = start; i < M; i++) {
			arr[cnt] = i;
			comb(cnt+1, i+1, arr);
		}
	}
}
