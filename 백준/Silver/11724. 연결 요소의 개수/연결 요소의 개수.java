import java.io.*;
import java.util.*;
 
public class Main {
	
	static int N, M, cnt;
	static boolean visited[], matrix[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			matrix[u][v] = matrix[v][u] = true;
		}
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static void dfs(int index) {
		visited[index] = true;
		for(int i = 1; i <= N; i++) {
			if(matrix[index][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
}