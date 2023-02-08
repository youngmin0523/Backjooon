import java.io.*;
import java.util.*;

public class Main {
	static int arr[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		arr[1] = Integer.parseInt(st.nextToken());
		for(int i = 2; i <= N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		for(int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			if(i == 1) {
				sb.append(arr[j]).append("\n");
			}
			else {
				sb.append(arr[j]-arr[i-1]).append("\n");
			}
		}
		System.out.println(sb);
	}
}