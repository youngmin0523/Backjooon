import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long cnt = 0;
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		if((A+B*cnt-C*cnt) <= (A+B*(cnt+1)-C*(cnt+1))) {
			System.out.println(-1);
			return;
		}
		
		while(A+B*cnt >= C*cnt) {
			cnt++;
		}
		System.out.println(cnt);
	}
}
