import java.io.*;
import java.util.*;


public class Main {
	
	static class Node implements Comparable<Node> {
		int num;
		boolean flag;
		
		Node(int num){
			this.num = num;
			this.flag = true;
		}

		@Override
		public int compareTo(Node o) {
			return this.num>=o.num?1:-1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			PriorityQueue<Node> minHeap = new PriorityQueue<>();
			PriorityQueue<Node> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			Node node = null;
			int cnt = 0;
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				switch(st.nextToken()) {
				case "I":
					int num = Integer.parseInt(st.nextToken());
					node = new Node(num);
					minHeap.offer(node);
					maxHeap.offer(node);
					cnt++;
					break;
				case "D":
					int comm = Integer.parseInt(st.nextToken());
					if(comm == 1) {
						node = null;
						while(!maxHeap.isEmpty()) {
							node = maxHeap.poll();
							if(node.flag) {
								break;
							}
						}
						if(node != null && node.flag) {
							node.flag = false;
							cnt--;
						}
					}
					else {
						node = null;
						while(!minHeap.isEmpty()) {
							node = minHeap.poll();
							if(node.flag) {
								break;
							}
						}
						if(node != null && node.flag) {
							node.flag = false;
							cnt--;
						}
					}
					break;
				}
			}
			node = null;
			if(cnt == 0) {
				sb.append("EMPTY");
			}
			else {
				while(!maxHeap.isEmpty()) {
					node = maxHeap.poll();
					if(node.flag) {
						break;
					}
				}
				sb.append(node.num).append(' ');
				while(!minHeap.isEmpty()) {
					node = minHeap.poll();
					if(node.flag) {
						break;
					}
				}
				sb.append(node.num);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}