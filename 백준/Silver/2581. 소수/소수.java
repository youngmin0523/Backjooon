import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		boolean first = false;
		boolean flag;
		int sum = 0, min = 0;
		
		for(int i = M; i <= N; i++) {
			if(i == 1) continue;
			flag = true;
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				if(!first) {
					min = i;
					first = true;
				}
				sum += i;
			}
		}
		if(!first) System.out.println(-1);
		else System.out.println(sum + "\n" + min);
	}
}
