import java.io.*;
import java.util.*;
 
public class Main {
 
	static int N, M, res;
	static boolean[][] arr;
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[N][M];
		res = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j) == 'W') {
					arr[i][j] = true; 
				}
				else {
					arr[i][j] = false;
				}
			}
		}
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				solve(i, j);
			}
		}
		System.out.println(res);
	}
	static void solve(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;
		boolean flag = arr[x][y];
 
		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {
				if (arr[i][j] != flag) {	
					count++;
				}
				flag = !flag;
			}
			flag = !flag;
		}
		count = Math.min(count, 64 - count);
		res = Math.min(res, count);
	}
}