import java.io.*;
import java.util.*;

public class Main {
	static int N, index;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Deque<Node> deq;
	static List<Integer> list;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		deq = new ArrayDeque<>();
		list = new ArrayList<>();
		
		deq.push(new Node(++index, Integer.parseInt(st.nextToken())));
		list.add(0);
		for(int i = 2; i <= N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			flag = true;
			while(true) {
				if(deq.isEmpty()) {
					flag = false;
					break;
				}
				if(deq.peek().height >= tmp) break;
				deq.pop();
			}
			if(flag) {
				list.add(deq.peek().index);
			}
			else {
				list.add(0);
			}
			deq.push(new Node(i, tmp));
		}
		for(int i = 0; i < N; i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}
	static class Node {
		int index;
		int height;
		
		Node(int index, int height){
			this.index = index;
			this.height = height;
		}
	}
}
