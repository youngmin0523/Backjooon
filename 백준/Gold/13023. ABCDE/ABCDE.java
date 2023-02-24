import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
 	static List<Integer> list[];
 	static boolean flag;
 	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i = 0; i < N; i++) {
			dfs(i, 0, 0 | (1<<i));
			if(flag) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	static void dfs(int current, int cnt, int mask) {
		if(cnt == 4) {
			flag = true;
			return;
		}
		
		for(int i = 0; i < list[current].size(); i++) {
			if((mask & (1<<list[current].get(i))) == 0) {
				dfs(list[current].get(i), cnt+1, mask | (1<<list[current].get(i)));
			}
		}
	}
}
