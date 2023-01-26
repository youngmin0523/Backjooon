import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int tmp, cnt = 0;
		boolean flag;
		
		for(int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			flag = true;
			if(tmp == 1) continue;
			
			for(int j = 2; j < tmp; j++) {
				if(tmp % j == 0) {
					flag = false;
				}
				if(!flag) break;
			}
			if(flag) cnt++;
		}
		System.out.println(cnt);
	}
}
