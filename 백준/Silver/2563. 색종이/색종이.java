import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[101][101];
		
		int N = Integer.parseInt(br.readLine());
		int x, y;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for(int j = x; j < x+10; j++) {
				for(int k = y; k < y+10; k++) {
					arr[j][k] = 1;
				}
			}
		}
		int cnt = 0;
		for(int j = 1; j <= 100; j++) {
			for(int k = 1; k <= 100; k++) {
				if(arr[j][k] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
