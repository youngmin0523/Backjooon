import java.io.*;
import java.util.*;
 
public class Main {
	
	static int N, matrix[][], white, blue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	static void dfs(int r, int c, int length) {
		boolean flag = true;
		int color = matrix[r][c];
		loop1 : for(int i = r; i < r+length; i++) {
			for(int j = c; j < c+length; j++) {
				if(matrix[i][j] != color) {
					flag = false;
					break loop1;
				}
			}
		}
		if(flag) {
			if(color == 0) {
				white++;
			}
			else {
				blue++;
			}
		}
		else {
			length /= 2;
			dfs(r, c, length);
			dfs(r+length, c, length);
			dfs(r, c+length, length);
			dfs(r+length, c+length, length);
		}
	}
}