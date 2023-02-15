import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, tmp, size;
	static Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			if(Math.abs(o1) == Math.abs(o2)) {
				return o1 - o2;
			}
			return Math.abs(o1) - Math.abs(o2);
		}
	});
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				if(heap.isEmpty()) {
					sb.append(0).append("\n");
					continue;
				}
				sb.append(heap.poll()).append("\n");
			}
			else {
				heap.offer(tmp);
			}
		}
			
		System.out.println(sb);
	}
}
