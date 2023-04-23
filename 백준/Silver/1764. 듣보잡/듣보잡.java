import java.io.*;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < N+M; i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				list.add(str);
			}
			else {
				set.add(str);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(String str : list) {
			System.out.println(str);
		}
	}
}