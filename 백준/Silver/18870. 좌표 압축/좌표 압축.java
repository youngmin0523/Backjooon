import java.io.*;
import java.util.*;

public class Main {
	static List<Node> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			list.add(new Node(i, value));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.value - o2.value;
			}
		});
		
		
		list.get(0).res = 0;
		for(int i = 1; i < N; i++) {
			if(list.get(i).value != list.get(i-1).value) {
				list.get(i).res = list.get(i-1).res + 1;
			}
			else {
				list.get(i).res = list.get(i-1).res;
			}
		}
		
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.index - o2.index;
			}
		});
		for(int i = 0; i < N; i++) {
			sb.append(list.get(i).res).append(" ");
		}
		System.out.println(sb);
	}
	static class Node{
		int index;
		int value;
		int res;
		
		Node(int index, int value){
			this.index = index;
			this.value = value;
		}
	}
}