import java.io.*;
import java.util.*;

public class Main {
	static int N, M, V;
	static int[][] matrix;
	static boolean visited[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		matrix = new int[N+1][N+1];
		
		int from, to;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			matrix[from][to] = 1;
			matrix[to][from] = 1;
		}
		dfs(V);
		bfs(V);
		System.out.println(sb);
	}
	static void bfs(int v){
		Queue<Integer> q = new ArrayDeque<>();
		visited = new boolean[N+1];
		q.offer(v);
		visited[v] = true;
		
		int tmp;
		while(!q.isEmpty()) {
			tmp = q.poll();
			sb.append(tmp).append(" ");
			
			for(int i = 1; i <= N; i++) {
				if(matrix[tmp][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		sb.append("\n");
	}
	static void dfs(int v) {
		ArrayDeque<Integer> s = new ArrayDeque<>();
		visited = new boolean[N+1];
		s.push(v);
//		visited[v] = true;
		
		int tmp;
		while(!s.isEmpty()) {
			tmp = s.pop();
			if(visited[tmp]) continue;
			visited[tmp] = true;
			sb.append(tmp).append(" ");
			
			for(int i = N; i >= 1; i--) {
				if(matrix[tmp][i] == 1 && !visited[i]) {
					s.push(i);
//					visited[i] = true;
				}
			}
		}
		sb.append("\n");
	}
}
