import java.util.*;
import java.io.*;
 
public class Main {
	
	static class Paper implements Comparable<Paper> {
		int pos, priority;

		public Paper(int pos, int priority) {
			super();
			this.pos = pos;
			this.priority = priority;
		}

		@Override
		public int compareTo(Paper o) {
			return -(this.priority-o.priority);
		}
	}
	
	static int N, M;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        
        for(int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	
        	LinkedList<Paper> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
 
			for (int i = 0; i < N; i++) {
				q.offer(new Paper(i, Integer.parseInt(st.nextToken())));
			}
			int count = 0;
			
			Paper front;
			while (!q.isEmpty()) {
				front = q.poll();
				boolean flag = true;
				
				for(int i = 0; i < q.size(); i++) {
					if(front.priority < q.get(i).priority) {
						q.offer(front);
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						flag = false;
						break;
					}
				}
				if(flag == false) {
					continue;
				}
				count++;
				if(front.pos == M) {
					break;
				}
			}
			sb.append(count).append('\n');
        }
        System.out.println(sb.toString());
    }
}    