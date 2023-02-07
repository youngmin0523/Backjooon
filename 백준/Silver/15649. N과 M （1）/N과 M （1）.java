import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int N, M, arr[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		arr = new int[M+1];
		
		perm(1);
		System.out.println(sb.toString());
    }
	static void perm(int index) {
		if(index > M) {
			for(int i = 1; i <= M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				arr[index] = i;
				visited[i] = true;
				perm(index+1);
				visited[i] = false;
			}	
		}
	}
}