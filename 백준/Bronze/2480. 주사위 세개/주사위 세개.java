import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		if(A != B && B != C && C != A) {
			int max = A;
			if(max < B) max = B;
			if(max < C) max = C;
			System.out.println(100 * max);
		}
		else if(A == B && B == C) {
			System.out.println(10000 + (A * 1000));
		}
		else {
			if(A == B || A == C) {
				System.out.println(1000 + (A * 100));
			}
			else {
				System.out.println(1000 + (B * 100));
			}
		}
		
	}
}
