import java.io.*;
import java.util.*;

public class Main {
	
	static List<Integer> num;
	static List<Character> oper;
	static int[] selected;
	static boolean[] visited;
	static int res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringTokenizer minusTokens = new StringTokenizer(str, "-");
		
		int sum = 0;
		boolean flag = true;
		
		while(minusTokens.hasMoreTokens()) {
			String subStr = minusTokens.nextToken();
			StringTokenizer plusTokens = new StringTokenizer(subStr, "+");
			
			int plusValue = 0;
			
			while(plusTokens.hasMoreTokens()) {
				plusValue += Integer.parseInt(plusTokens.nextToken());
			}
			if(flag) {
				sum += plusValue;
				flag = false;
			}
			else {
				sum -= plusValue;
			}
		}
		System.out.println(sum);
	}
}
