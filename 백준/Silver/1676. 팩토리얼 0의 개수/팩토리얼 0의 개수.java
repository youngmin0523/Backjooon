import java.io.*;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while (num >= 5) {
			cnt += num / 5;
			num /= 5;
		}
		System.out.println(cnt);
	}
}