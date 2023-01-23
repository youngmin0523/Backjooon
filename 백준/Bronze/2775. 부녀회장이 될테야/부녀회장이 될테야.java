import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int k, n;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			System.out.println(recursive(k, n));
		}
	}
	static int recursive(int k, int n) {
		if(k == 0) return n;
		int tmp = 0;
		for(int i = 1; i <= n;  i++) {
			tmp += recursive(k-1, i);
		}
		return tmp;
	}
}
