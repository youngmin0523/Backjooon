import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		int res = 0;
		
		N /= 100;
		N *= 100;
		
		while((N+res)%F != 0 && res < 100) res++;
		
		System.out.println(res<10?"0"+res:res);
	}
}