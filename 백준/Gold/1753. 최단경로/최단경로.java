import java.io.*;
import java.util.*;

public class Main {
 	static class Edge implements Comparable<Edge>{
 		int v, w;

		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		
 	}
	
	static int V, E, K, distance[];
	static List<Edge> edgeList[];
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		edgeList = new List[V+1];
		for(int i = 1; i <= V; i++) {
			edgeList[i] = new ArrayList<>();
		}
		int u, v, w;
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			edgeList[u].add(new Edge(v, w));
		}
		dijkstra();
		for(int i = 1; i <= V; i++) {
			sb.append(distance[i]==INF?"INF":distance[i]).append('\n');
		}
		System.out.print(sb.toString());
	}
	static void dijkstra() {
		boolean visited[] = new boolean[V+1];
		distance = new int[V+1];
		Arrays.fill(distance, INF);
		distance[K] = 0;
		
		Queue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(K, 0));
		
		Edge current = null;
		while(!pq.isEmpty()) {
			current = pq.poll();
			if(visited[current.v]) continue;
			visited[current.v] = true;
			
			for(Edge vertex : edgeList[current.v]) {
				if(!visited[vertex.v] && distance[vertex.v] > current.w+vertex.w) {
					distance[vertex.v] = current.w+vertex.w;
					pq.offer(new Edge(vertex.v, distance[vertex.v]));
				}
			}
		}
	}
}
