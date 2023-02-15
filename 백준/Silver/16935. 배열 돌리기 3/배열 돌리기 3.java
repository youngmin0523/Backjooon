import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, R, A[][], cnt, m, n;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			exe(Integer.parseInt(st.nextToken()));
		}
		if(cnt%2 == 0) {
			n = N;
			m = M;
		}
		else {
			n = M;
			m = N;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	static void exe(int r) {
		int tmp_arr2[][], tmp_arr[], tmp;
		if(cnt%2 == 0) {
			n = N;
			m = M;
		}
		else {
			n = M;
			m = N;
		}
		switch(r) {
		case 1:
			tmp_arr = new int[n+1];
			for(int i = 1; i <= n/2; i++) {
				tmp_arr = A[i];
				A[i] = A[n-i+1];
				A[n-i+1] = tmp_arr;
			}
			break;
		case 2:
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m/2; j++) {
					tmp = A[i][j];
					A[i][j] = A[i][m-j+1];
					A[i][m-j+1] = tmp;
				}
			}
			break;
		case 3:
			tmp_arr2 = new int[m+1][n+1];
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++) {
					tmp_arr2[j][n-i+1] = A[i][j];
				}
			}
			A = tmp_arr2;
			cnt++;
			break;
		case 4:
			tmp_arr2 = new int[m+1][n+1];
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++) {
					tmp_arr2[m-j+1][i] = A[i][j];
				}
			}
			A = tmp_arr2;
			cnt++;
			break;
		case 5:
			tmp_arr2 = new int[n/2+1][m/2+1];
			for(int i = 1; i <= n/2; i++) {
				for(int j = 1; j <= m/2; j++) {
					tmp_arr2[i][j] = A[i][j];
				}
			}
			for(int i = 1; i <= n/2; i++) {
				for(int j = 1; j <= m/2; j++) {
					A[i][j] = A[i+n/2][j];
				}
			}
			for(int i = n/2+1; i <= n; i++) {
				for(int j = 1; j <= m/2; j++) {
					A[i][j] = A[i][j+m/2];
				}
			}
			for(int i = n/2+1; i <= n; i++) {
				for(int j = m/2+1; j <= m; j++) {
					A[i][j] = A[i-n/2][j];
				}
			}
			for(int i = 1; i <= n/2; i++) {
				for(int j = m/2+1; j <= m; j++) {
					A[i][j] = tmp_arr2[i][j-m/2];
				}
			}

			break;
		case 6:
			tmp_arr2 = new int[n/2+1][m/2+1];
			for(int i = 1; i <= n/2; i++) {
				for(int j = 1; j <= m/2; j++) {
					tmp_arr2[i][j] = A[i][j];
				}
			}
			for(int i = 1; i <= n/2; i++) {
				for(int j = 1; j <= m/2; j++) {
					A[i][j] = A[i][j+m/2];
				}
			}
			for(int i = 1; i <= n/2; i++) {
				for(int j = m/2+1; j <= m; j++) {
					A[i][j] = A[i+n/2][j];
				}
			}
			for(int i = n/2+1; i <= n; i++) {
				for(int j = m/2+1; j <= m; j++) {
					A[i][j] = A[i][j-m/2];
				}
			}
			for(int i = n/2+1; i <= n; i++) {
				for(int j = 1; j <= m/2; j++) {
					A[i][j] = tmp_arr2[i-n/2][j];
				}
			}
			break;
		}
	}
}
