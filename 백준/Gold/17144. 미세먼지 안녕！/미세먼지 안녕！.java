import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, T, map[][], copyMap[][];
	static int[] aircon = new int[2];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		int tmp = 0;
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) {
					aircon[tmp++] = r;
				}
			}
		}
		for(int time = 0; time < T; time++) {
			go();
		}
		int cnt = 2;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				cnt += map[r][c];
			}
		}
		System.out.println(cnt);
	}
	static void go() {
		// 동시 확산양 구하기
		copyMap = new int[R][C];
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] > 0) {
					spread(r, c);
				}
			}
		}
		// 확산 결과 합치기
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				map[r][c] += copyMap[r][c];
			}
		}
		// 위쪽 반시계
		for(int r = aircon[0]-1; r > 0; r--) {
			map[r][0] = map[r-1][0];
		}
		for(int c = 0; c < C-1; c++) {
			map[0][c] = map[0][c+1];
		}
		for(int r = 0; r < aircon[0]; r++) {
			map[r][C-1] = map[r+1][C-1];
		}
		for(int c = C-1; c > 1; c--) {
			map[aircon[0]][c] = map[aircon[0]][c-1];
		}
		map[aircon[0]][1] = 0;
		
		// 아래쪽 시계
		for(int r = aircon[1]+1; r < R-1; r++) {
			map[r][0] = map[r+1][0];
		}
		for(int c = 0; c < C-1; c++) {
			map[R-1][c] = map[R-1][c+1];
		}
		for(int r = R-1; r > aircon[1]; r--) {
			map[r][C-1] = map[r-1][C-1];
		}
		for(int c = C-1; c > 1; c--) {
			map[aircon[1]][c] = map[aircon[1]][c-1];
		}
		map[aircon[1]][1] = 0;
	}
	static void spread(int r, int c) {
		int nr, nc;
		int amount = map[r][c]/5;
		for(int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(range(nr, nc) && map[nr][nc] > -1) {
				copyMap[nr][nc] += amount;
				map[r][c] -= amount;
			}
		}
	}
	static boolean range(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
