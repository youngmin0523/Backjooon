import java.io.*;
import java.util.*;

public class Main {
	static int N,K, index;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		sb.append("<");
		index = K-1;
		while(true) {
			sb.append(list.remove(index));
			if(list.isEmpty()) break;
			sb.append(", ");
			index = (index + (K-1)) % list.size();
		}
		sb.append(">");
		System.out.println(sb);
		
	}
}
