import java.io.*;
import java.util.*;

public class Main {
	static boolean[] prime;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			int cnt = 0;
			prime = new boolean[2*n+1];
			for(int i = 2; i <= n; i++) {
				isPrime(i);
			}
			prime[0] = prime[1] = true;
			prime[2] = false;
			
			for(int i = n+1; i <= 2*n; i++) {
				if(!prime[i])
					cnt++;
			}
			System.out.println(cnt);
		}
	}
	static void isPrime(int index) {
		if(prime[index] || index > 2*n) return;
		prime[index] = true;
		
		int i = 2;
		while(index*i <= 2*n) {
			isPrime(index*i);
			i++;
		}
	}
}
