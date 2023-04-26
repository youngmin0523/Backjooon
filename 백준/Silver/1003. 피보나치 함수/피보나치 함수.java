import java.io.*;
import java.util.*;
 
public class Main {
 
	static int fibo[][], N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		fibo = new int[41][2];
		fibo[0][0] = 0; fibo[0][1] = 1; fibo[1][0] = 1; fibo[1][1] = 0;
		
		for(int i = 2; i <= 40; i++) {
			fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
			fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
		}
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(fibo[N][1] + " " + fibo[N][0]);
		}
	}

}