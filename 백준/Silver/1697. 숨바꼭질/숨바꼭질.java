import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N));
	}
	static int bfs(int v) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[100001];
		q.offer(v);
		visited[v] = true;
		
		int time = 0;
		int tmp, next;
		int currentSize = 1, nextSize = 0;
		while(!q.isEmpty()) {
			tmp = q.poll();
			currentSize--;
			if(tmp == K) {
				return time;
			}
			next = tmp-1;
			if(next >= 0 && !visited[next]) {
				q.offer(next);
				visited[next] = true;
				nextSize++;
			}
			next = tmp+1;
			if(next <= 100000 && !visited[next]) {
				q.offer(next);
				visited[next] = true;
				nextSize++;
			}
			next = tmp*2;
			if(next <= 100000 && tmp != 0 && !visited[next]) {
				q.offer(next);
				visited[next] = true;
				nextSize++;
			}
			if(currentSize == 0) {
				currentSize = nextSize;
				nextSize = 0;
				time++;
			}
		}
		return -1;
	}
}
