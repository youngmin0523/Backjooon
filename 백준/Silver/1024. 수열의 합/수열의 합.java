import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int t, x = -1, iter=-1;
		
		for(int i = L; i <= 100; i++) {
			t = (i-1)*i/2;
			if((N-t)%i == 0 && (N-t)/i >= 0) {
				x = (N-t)/i;
				iter = i;
				break;
			}
		}
		
		if(x == -1) {
			System.out.println(-1);
		}
		else {
			for(int i = 0; i < iter; i++) {
				System.out.print(x+i + " ");
			}
		}
	}
}