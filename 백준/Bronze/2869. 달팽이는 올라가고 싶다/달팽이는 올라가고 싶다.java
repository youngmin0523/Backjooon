import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int C = A-B, day, current = 0;
		
		for(int i = 1; ; i++) {
			if(i*C >= A) {
				C = i*C;
				break;
			}
		}
		
		day = (V-C) / (A-B);
		V -= day * (A-B);
		
		while(true) {
			day++;
			if(current + A >= V) break;
			current += (A-B);
		}
		System.out.println(day);
	}

}
