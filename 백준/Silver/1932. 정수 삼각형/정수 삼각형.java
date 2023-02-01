import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][n];
		
		triangle[0][0] = Integer.parseInt(br.readLine());
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				if(j == 0) {
					triangle[i][j] = triangle[i-1][j] + Integer.parseInt(st.nextToken());
				}
				else if(j == i) {
					triangle[i][j] = triangle[i-1][j-1] + Integer.parseInt(st.nextToken());
				}
				else {
					triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j])
							+ Integer.parseInt(st.nextToken());
				}
			}
		}
		int max = triangle[n-1][0];
		for(int i = 1; i < n; i++) {
			if(max < triangle[n-1][i])
				max = triangle[n-1][i];
		}
		System.out.println(max);
	}
}
