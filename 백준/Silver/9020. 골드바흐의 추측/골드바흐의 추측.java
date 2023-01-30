import java.io.*;
import java.util.*;

public class Main {
	static boolean[] prime = new boolean[10001];
	static int a, b, N = 10000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n;
		
		for(int i = 2; i <= N/2; i++) {
			isPrime(i, 0);
		}
		
		for(int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			partition(n);
			System.out.println(a + " " + b);
		}
		
		
	}
	static void partition(int n) {
		for(int i = n/2; i >= 2; i--) {
			if(!prime[i] && !prime[n-i]) {
				a = i; b = n-i;
				return;
			}
		}
	}
	static void isPrime(int index, int cnt) {
		if(prime[index] || index > N) return;
		if(cnt == 1) prime[index] = true;
		
		int i = 2;
		while(index*i <= N) {
			isPrime(index*i, 1);
			i++;
		}
	}
}
