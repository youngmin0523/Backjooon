import java.io.*;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		String[] arr = new String[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = br.readLine();
			map.put(arr[i], i);
		}
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			try {
				int n = Integer.parseInt(str);
				System.out.println(arr[n]);
			} catch(Exception e) {
				System.out.println(map.get(str));
			}
		}
	}
}