import java.io.*;
import java.util.*;
 
public class Main {
	
	static int N, M, cnt, K;
	static boolean matrix[][];
	static List<int[]> list;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			matrix = new boolean[N][M];
			list = new ArrayList<>();
			cnt = 0;
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				matrix[r][c] = true;
				list.add(new int[] {r, c});
			}
			for(int[] pos : list) {
				if(matrix[pos[0]][pos[1]]) {
					cnt++;
					dfs(pos[0], pos[1]);
				}
			}
			System.out.println(cnt);
		}
	}
	static void dfs(int r, int c) {
		matrix[r][c] = false;
		
		int nr, nc;
		for(int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(range(nr, nc) && matrix[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
	static boolean range(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}