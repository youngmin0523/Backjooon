import java.io.*;
import java.util.*;

public class Main {
	
	static int N, map[][], dp[][][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		dp = new int[3][N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		System.out.println(dp[0][N][N]+dp[1][N][N]+dp[2][N][N]);
	}
	static void solve() {
		dp[0][1][2] = 1;
		
		for(int r = 1; r <= N; r++) {
			for(int c = 2; c <= N; c++) {
				if(range(r, c+1) && map[r][c+1] == 0) {
					dp[0][r][c+1] += dp[0][r][c];
					if(range(r+1, c+1) && map[r+1][c+1] == 0 && map[r+1][c] == 0) {
						dp[2][r+1][c+1] += dp[0][r][c];
					}
				}
				if(range(r+1, c) && map[r+1][c] == 0) {
					dp[1][r+1][c] += dp[1][r][c];
					if(range(r+1, c+1) && map[r+1][c+1] == 0 && map[r][c+1] == 0) {
						dp[2][r+1][c+1] += dp[1][r][c];
					}
				}
				if(range(r+1, c) && map[r+1][c] == 0) {
					dp[1][r+1][c] += dp[2][r][c];
					if(range(r+1, c+1) && map[r+1][c+1] == 0 && map[r][c+1] == 0) {
						dp[2][r+1][c+1] += dp[2][r][c];
					}
				}
				if(range(r, c+1) && map[r][c+1] == 0) {
					dp[0][r][c+1] += dp[2][r][c];
				}
			}
		}
		
	}
	static boolean range(int r, int c) {
		return r >=1 && r <= N && c >= 1 && c <= N;
	}
}
