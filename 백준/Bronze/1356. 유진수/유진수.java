import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
		int[] x = new int[arr.length];
		int[] y = new int[arr.length];
		for(int i = 0; i < arr.length - 1; i++) {
			int j = arr.length - 1 - i;
			if(i == 0) {
				x[i] = (int)(arr[i] - '0');
				y[j] = (int)(arr[j] - '0');
				continue;
			}
			x[i] = x[i - 1] * (int)(arr[i] - '0');
			y[j] = y[j + 1] * (int)(arr[j] - '0');
		}
		boolean flag = false;
		for(int i = 0; i < arr.length - 1; i++) {
			if(x[i] == y[i + 1]) {
				flag = true;
				break;
			}
		}
		System.out.print(flag?"YES":"NO");
	}
}