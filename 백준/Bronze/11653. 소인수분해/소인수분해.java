import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		boolean flag;
		
		while(true) {
			flag = false;
			for(int i = 2; i <= N; i++) {
				if(N % i == 0) {
					sb.append(i).append("\n");
					N /= i;
					flag = true;
					break;
				}
			}
			if(!flag) break;
		}
		System.out.println(sb.toString());
	}
}
