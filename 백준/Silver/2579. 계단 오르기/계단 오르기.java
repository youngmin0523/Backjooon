import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] stairs;
	static int[] dp;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		stairs = new int[N+1];
		dp = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = stairs[1];
		if(N >= 2)
			dp[2] = stairs[1] + stairs[2];
		for(int i = 3; i <= N; i++) {
			setMaxScore(i);
		}
		System.out.println(dp[N]);
	}
	static void setMaxScore(int index) {
		dp[index] = Math.max(dp[index-2], dp[index-3] + stairs[index-1]);
		dp[index] += stairs[index];
	}
	
}
