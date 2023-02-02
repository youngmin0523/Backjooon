import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] table = new int[N+1][N+1];
		int x1, x2, y1, y2, tmp, sum;
		
		
		for(int i = 1; i <= N; i++) {
			tmp = 0;
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken()) + tmp;
				tmp = table[i][j];
			}
		}
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j <= N; j++)
				table[i][j] += table[i-1][j];
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			sum = 0;
			if(y1 == 1) {
				if(x1 == 1) {
					sum += table[x2][y2];
				}
				else {
					sum += table[x2][y2] - table[x1-1][y2];
				}
			}
			else {
				if(x1 == 1) {
					sum += table[x2][y2] - table[x2][y1-1];
				}
				else {
					sum += table[x2][y2] - table[x2][y1-1] - table[x1-1][y2] + table[x1-1][y1-1];
				}
			}
			System.out.println(sum);
		}
	}
}
