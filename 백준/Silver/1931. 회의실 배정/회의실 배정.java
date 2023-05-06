import java.io.*;
import java.util.*;
 
public class Main {
	
	static class Node implements Comparable<Node> {
		int start, end;
		
		Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			return this.end-o.end;
		}
	}
	
	static int N;
	static List<Node> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		int cnt = 0;
		int time = 0;
		for(Node curr : list) {
			if(time <= curr.start) {
				time = curr.end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}