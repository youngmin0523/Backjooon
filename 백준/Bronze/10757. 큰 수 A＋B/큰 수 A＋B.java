import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		int length = Math.max(A.length(), B.length());
		int tmp;
		
		int[] a = new int[length+1];
		int[] b = new int[length+1];
		
		for(int i  = 0; i < A.length(); i++) {
			a[i] = A.charAt(A.length()-1-i) - '0';
		}
		for(int i = 0; i < B.length(); i++) {
			b[i] = B.charAt(B.length()-1-i) - '0';
		}
		
		for(int i = 0; i < length; i++) {
			tmp = a[i] + b[i];
			if(tmp >= 10) {
				a[i] = tmp-10;
				a[i+1]++;
			}
			else {
				a[i] = tmp;
			}
		}
		if(a[length] != 0) 
			System.out.print(a[length]);
		for(int i = length-1; i >= 0; i--) {
			System.out.print(a[i]);
		}
	}
}
