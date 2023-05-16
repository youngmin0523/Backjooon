import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		boolean flag = true;
		for(int i = 0; i <= str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-i-1)) {
				flag = false;
				break;
			}
		}
		System.out.println(flag?1:0);
	}
}