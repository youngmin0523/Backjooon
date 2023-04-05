import java.io.*;
import java.util.*;

public class Main {

	static int N, d, k, c, res, dish[], flag[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dish = new int[N];
		flag = new int[3001];
		
		for(int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < k; i++) {
			if(flag[dish[i]]++ == 0) {
				res++;
			}
		}
		int cnt = res;
		if(flag[c] == 0) {
			res++;
		}
		
		for(int i = 1; i < N; i++) {
			int push = dish[(i+k-1)%N];
			int pop = dish[i-1];
			
			if(push != pop) {
				if(--flag[pop] == 0) {
					cnt--;
				}
				if(flag[push]++ == 0) {
					cnt++;
				}
				res = Math.max(res, flag[c]==0?cnt+1:cnt);
			}
		}
		System.out.println(res);
	}
}
