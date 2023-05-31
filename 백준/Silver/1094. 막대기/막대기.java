import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int res = 0;
		while(X>0) {
			if(X % 2 == 1) {
				res++;
			}
			X /= 2;
		}
		System.out.println(res);
	}
}