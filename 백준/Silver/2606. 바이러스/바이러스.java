import java.io.*;
import java.util.*;
 
public class Main {
	
	static int N, M, cnt;
	static boolean visited[], matrix[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		matrix = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			matrix[u][v] = matrix[v][u] = true;
		}
		dfs(1);
		System.out.println(cnt-1);
	}
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		
		int curr;
		while(!q.isEmpty()) {
			curr = q.poll();
			for(int i = 1; i <= N; i++) {
				if(matrix[curr][i] && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
		
	}
	static void dfs(int index) {
		visited[index] = true;
		cnt++;
		for(int i = 1; i <= N; i++) {
			if(matrix[index][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
}