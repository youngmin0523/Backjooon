import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
       
		int min1 = 1000, min2 = 1000;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			min1 = Math.min(min1, Integer.parseInt(st.nextToken()));
			min2 = Math.min(min2, Integer.parseInt(st.nextToken()));
		}
		int mod1 = N/6;
		int mod2 = N%6;
		if(mod2*min2 >= min1) {
			System.out.println(min1*mod1+min1);
		}
		else if(min2*6 < min1) {
			System.out.println(N*min2);
		}
		else {
			System.out.println(mod1*min1 + mod2*min2);
		}
	}
}