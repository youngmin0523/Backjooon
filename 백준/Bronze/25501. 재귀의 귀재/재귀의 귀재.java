import java.io.*;
import java.util.*;

public class Main {
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			cnt = 0;
			char[] str = br.readLine().toCharArray();
			sb.append(recursion(str, 0, str.length-1)).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		
	}
	static int recursion(char[] str, int l, int r) {
		cnt++;
		if(l >= r) {
			return 1;
		}
		if(str[l] != str[r]) return 0;
		else return recursion(str, l+1, r-1);
	}
}