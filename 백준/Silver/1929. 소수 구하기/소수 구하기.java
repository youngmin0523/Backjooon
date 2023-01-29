import java.io.*;
import java.util.*;

public class Main {
	static boolean[] prime;
	static int M, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		prime = new boolean[N+1];
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= N/2; i++) {
			isPrime(i);
		}
		for(int i = M; i <= N; i++) {
			if(!prime[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
	static void isPrime(int index) {
		if(prime[index]) return;
		int i = 2;
		while(index*i <= N) {
			prime[index*i] = true;
			i++;
		}
		
	}
}
