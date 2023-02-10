import java.io.*;
import java.util.*;

public class Main {
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		int tmp;
		while(true) {
			tmp = q.poll();
			if(q.isEmpty()) {
				break;
			}
			tmp = q.poll();
			if(q.isEmpty()) {
				break;
			}
			q.offer(tmp);
		}
		
		System.out.println(tmp);
	}
}
