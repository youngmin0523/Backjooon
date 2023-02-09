import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(N));
		
	}
	static int factorial(int n) {
		if(n <= 1) return 1;
		return n * factorial(n-1);
	}
}