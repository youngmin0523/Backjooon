import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int q[], front, rear;
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		q = new int[10000];
		
		for(int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push":
				q[rear++] = Integer.parseInt(st.nextToken());
				break;
			case "pop":
				System.out.println(front==rear?-1:q[front++]);
				break;
			case "size":
				System.out.println(rear-front);
				break;
			case "empty":
				System.out.println(front==rear?1:0);
				break;
			case "front":
				System.out.println(front==rear?-1:q[front]);
				break;
			case "back":
				System.out.println(front==rear?-1:q[rear-1]);
				break;
			}
			
		}
		
		
	}
}
