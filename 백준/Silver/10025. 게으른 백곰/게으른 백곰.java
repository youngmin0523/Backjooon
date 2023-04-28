import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] baskets = new int[1000001];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			baskets[x] = g;
		}
		int sum = 0;
		for(int i = 0; i <= 2*K; i++) {
			if(i > 1000000) break;
			sum += baskets[i];
		}
		
		int res = sum;
		for(int i = 1+2*K, j = 0; i <= 1000000; i++, j++) {
			sum -= baskets[j];
			sum += baskets[i];
			res = Math.max(res, sum);
		}
		System.out.println(res);
	}
}