import java.io.*;
import java.util.*;

public class Main {
	static int arr[];
	static int N, M;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		perm(0, 1);
		System.out.println(sb);
	}
	static void perm(int cnt, int start) {
		if(cnt == M) {
			for(int it : arr) {
				sb.append(it).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i <= N; i++) {
			arr[cnt] = i;
			perm(cnt+1, i+1);
			
		}
		
	}
}