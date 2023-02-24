import java.io.*;
import java.util.*;

public class Main {
	static class CCTV{
		int r, c, num;

		public CCTV(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	
	static int N, M, map[][], res = Integer.MAX_VALUE;
	static List<CCTV> cctvs;
 	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvs= new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >= 1 && map[i][j] <= 5) {
					cctvs.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		int[][] copyMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			copyMap[i] = Arrays.copyOf(map[i], M);
		}
		if(cctvs.size() == 0) {
			getCnt(map);
		}
		else {
			dfs(0, cctvs.get(0), copyMap);
		}
		System.out.println(res);
	}
	static void dfs(int depth, CCTV cctv, int[][] map) {
		int[][] copyMap = new int[N][M];
		int[][] tmpMap = new int[N][M];
		
		switch(cctv.num) {
		case 1:
			for(int k = 0; k < 4; k++) {
				for(int J = 0; J < N; J++) {
					tmpMap[J] = Arrays.copyOf(map[J], M);
				}
				fill(tmpMap, cctv, k);
				if(depth+1 == cctvs.size()) {
					getCnt(tmpMap);
					continue;
				}
				for(int J = 0; J < N; J++) {
					copyMap[J] = Arrays.copyOf(tmpMap[J], M);
				}
				dfs(depth+1, cctvs.get(depth+1), copyMap);
			}
			break;
		case 2:
			for(int k = 0; k < 2; k++) {
				for(int J = 0; J < N; J++) {
					tmpMap[J] = Arrays.copyOf(map[J], M);
				}
				fill(tmpMap, cctv, (k+1)%4);
				fill(tmpMap, cctv, (k+3)%4);
				if(depth+1 == cctvs.size()) {
					getCnt(tmpMap);
					continue;
				}
				for(int J = 0; J < N; J++) {
					copyMap[J] = Arrays.copyOf(tmpMap[J], M);
				}
				dfs(depth+1, cctvs.get(depth+1), copyMap);
			}
			break;
		case 3:
			for(int k = 0; k < 4; k++) {
				for(int J = 0; J < N; J++) {
					tmpMap[J] = Arrays.copyOf(map[J], M);
				}
				fill(tmpMap, cctv, k%4);
				fill(tmpMap, cctv, (k+1)%4);
				if(depth+1 == cctvs.size()) {
					getCnt(tmpMap);
					continue;
				}
				for(int J = 0; J < N; J++) {
					copyMap[J] = Arrays.copyOf(tmpMap[J], M);
				}
				dfs(depth+1, cctvs.get(depth+1), copyMap);
			}
			break;
		case 4:
			for(int k = 0; k < 4; k++) {
				for(int J = 0; J < N; J++) {
					tmpMap[J] = Arrays.copyOf(map[J], M);
				}
				fill(tmpMap, cctv, k%4);
				fill(tmpMap, cctv, (k+1)%4);
				fill(tmpMap, cctv, (k+2)%4);
				if(depth+1 == cctvs.size()) {
					getCnt(tmpMap);
					continue;
				}
				for(int J = 0; J < N; J++) {
					copyMap[J] = Arrays.copyOf(tmpMap[J], M);
				}
				dfs(depth+1, cctvs.get(depth+1), copyMap);
			}
			break;
		case 5:
			for(int J = 0; J < N; J++) {
				tmpMap[J] = Arrays.copyOf(map[J], M);
			}
			fill(tmpMap, cctv, 0);
			fill(tmpMap, cctv, 1);
			fill(tmpMap, cctv, 2);
			fill(tmpMap, cctv, 3);
			if(depth+1 == cctvs.size()) {
				getCnt(tmpMap);
				return;
			}
			for(int J = 0; J < N; J++) {
				copyMap[J] = Arrays.copyOf(tmpMap[J], M);
			}
			dfs(depth+1, cctvs.get(depth+1), copyMap);
		}
	}
	static void fill(int[][] tmpMap, CCTV cctv, int type) {
		switch(type) {
		case 0:
			for(int i = cctv.r-1; i >= 0; i--) {
				if(range(i, cctv.c)) {
					if(tmpMap[i][cctv.c] == 6) {
						break;
					}
					tmpMap[i][cctv.c] = 1;
				}
			}
			break;
		case 1:
			for(int i = cctv.c+1; i < M; i++) {
				if(range(cctv.r, i)) {
					if(tmpMap[cctv.r][i] == 6) {
						break;
					}
					tmpMap[cctv.r][i] = 1;
				}
			}
			break;
		case 2:
			for(int i = cctv.r+1; i < N; i++) {
				if(range(i, cctv.c)) {
					if(tmpMap[i][cctv.c] == 6) {
						break;
					}
					tmpMap[i][cctv.c] = 1;
				}
			}
			break;
		case 3:
			for(int i = cctv.c-1; i >= 0; i--) {
				if(range(cctv.r, i)) {
					if(tmpMap[cctv.r][i] == 6) {
						break;
					}
					tmpMap[cctv.r][i] = 1;
				}
			}
		}
	}
	static boolean range(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	static void getCnt(int[][] map) {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					cnt++;
				}
			}
		}
		if(cnt < res) {
			res = cnt;
		}
	}
}
