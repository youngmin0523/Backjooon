import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		while(!(str=br.readLine()).equals("0")) {
			flag = true;
			for(int i = 0; i < str.length()/2; i++) {
				if(str.charAt(i) != str.charAt(str.length()-i-1)) {
					flag = false;
					break;
				}
			}
			System.out.println(flag?"yes":"no");
		}
		
		
	}
}
