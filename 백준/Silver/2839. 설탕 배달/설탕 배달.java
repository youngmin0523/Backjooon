import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int bag5, bag3, n;
		
		bag5 = N / 5;
		n = N - bag5*5;
		while(true) {
			if(n%3 == 0) {
				bag3 = n / 3;
				break;
			}
			if(n+5 > N) {
				System.out.println(-1);
				return;
			}
			n += 5;
			bag5 -= 1;
		}
		System.out.println(bag5+bag3);
	}
}
