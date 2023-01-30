import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		char[] arr;
		int cnt, score;
		boolean flag;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			arr = br.readLine().toCharArray();
			flag = false;
			cnt = 1; score = 0;
			
			for(char it : arr) {
				if(it == 'O') {
					if(!flag) {
						cnt = 1;
						flag = true;
					}
					else cnt++;
					score += cnt;
				}
				else {
					flag = false;
				}
				
			}
			sb.append(score).append("\n");
		}
		System.out.println(sb);
	}
}
