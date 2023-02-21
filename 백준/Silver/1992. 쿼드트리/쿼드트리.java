import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char map[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		dfs(0, 0, N);
		System.out.println(sb);
	}
	static void dfs(int r, int c, int size) {
		
		char tmp = map[r][c];
		boolean flag = true;
		loop1:for(int i = r; i < r+size; i++) {
			for(int j = c; j < c+size; j++) {
				if(map[i][j] != tmp) {
					flag = false;
					break loop1;
				}
			}
		}
		if(flag) {
			sb.append(tmp);
			return;
		}
		sb.append("(");
		dfs(r, c, size/2);
		dfs(r, c+size/2, size/2);
		dfs(r+size/2, c, size/2);
		dfs(r+size/2, c+size/2, size/2);
		sb.append(")");
	}
}
