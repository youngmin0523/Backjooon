import java.io.*;
import java.util.*;
 
public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String key = st.nextToken();
				if(map.containsKey(key)) {
					map.put(key, map.get(key)+1);
				}
				else {
					map.put(key, 1);
				}
			}
			int res = 1;
			for(int n : map.values()) {
				res *= (n+1);
			}
			System.out.println(res-1);
		}
	}
}