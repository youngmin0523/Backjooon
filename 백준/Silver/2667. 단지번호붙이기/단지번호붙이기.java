import java.io.*;
import java.util.*;
 
public class Main {
	
	static class Pos{
		int r, c;
		
		Pos(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int map[][];
	static boolean visited[][];
	static List<Integer> list;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					cnt++;
					list.add(bfs(i, j));
				}
			}
		}
		sb.append(cnt).append('\n');
		Collections.sort(list);
		for(int it : list) {
			sb.append(it).append('\n');
		}
		System.out.println(sb.toString());
	}
	static int bfs(int r, int c) {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(r, c));
		visited[r][c] = true;
		int cnt = 1;
		
		Pos curr;
		while(!q.isEmpty()) {
			curr = q.poll();
			
			int nr, nc;
			for(int d = 0; d < 4; d++) {
				nr = curr.r + dr[d];
				nc = curr.c + dc[d];
				
				if(range(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					cnt++;
					q.offer(new Pos(nr, nc));
				}
			}
		}
		return cnt;
	}
	static boolean range(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}