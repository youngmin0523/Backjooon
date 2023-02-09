import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(N));
		
	}
	static int fibo(int n) {
		if(n <= 1) return n;
		
		return fibo(n-2) + fibo(n-1);
	}
}