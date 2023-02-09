import java.io.*;
import java.util.*;

public class Main {
	static int N, S[], B[], min = Integer.MAX_VALUE;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		brute_force(0);
		System.out.println(min);
	}
	static void brute_force(int cnt) {
		if(cnt == N) {
			boolean flag = false;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					flag = true;
				}
			}
			if(!flag) return;
			
			int s = 1, b = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					s *= S[i];
					b += B[i];
				}
			}
			int tmp = Math.abs(s-b);
			if(tmp < min) {
				min = tmp;
			}
			return;
		}
		isSelected[cnt] = true;
		brute_force(cnt+1);
		isSelected[cnt] = false;
		brute_force(cnt+1);
	}
}