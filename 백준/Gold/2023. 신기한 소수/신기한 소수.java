import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());	
		
		getPrime(0, 0);
		System.out.println(sb);
	}
	static void getPrime(int cnt, int num) {
		if(cnt == N) {
			sb.append(num).append("\n");
			return;
		}
		for(int i = 0; i < 10; i++) {
			int tmp = num * 10 + i;
			if(isPrime(tmp)) {
				getPrime(cnt+1, tmp);
			}
		}
	}
	
	static boolean isPrime(int num) {
		if(num <= 1) return false;
		for(int i = 2; i*i <= num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}