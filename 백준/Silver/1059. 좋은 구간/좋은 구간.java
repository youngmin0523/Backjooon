import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int[] arr = new int[L];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < L; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int n = Integer.parseInt(br.readLine());
		
		int r = 1001, l = -1001;
		
		for(int i = 0; i < L; i++) {
			if(arr[i] - n >= 0) {
				r = Math.min(r, arr[i]-n);
			}
			else {
				l = Math.max(l, arr[i]-n);
			}
		}
		
		if(r != 1001 && l != -1001 && r != 0) {
			System.out.println(Math.abs(r*l)-1);
		}
		else if(l == -1001 && r != 0) {
			System.out.println(n*r-1);
		}
		else if(r == 0) {
			System.out.println(0);
		}
	}
}