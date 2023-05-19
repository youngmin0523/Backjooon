import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(num/25).append(' ');
			num %= 25;
			sb.append(num/10).append(' ');
			num %= 10;
			sb.append(num/5).append(' ');
			num %= 5;
			sb.append(num/1).append('\n');
			
		}
		System.out.println(sb.toString());
	}
}