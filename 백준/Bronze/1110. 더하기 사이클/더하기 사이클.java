import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int  N = Integer.parseInt(br.readLine());
		int tmp = N;
		int cnt = 0;
		
		do {
			cnt++;
			tmp = (tmp%10*10) + ((tmp/10 + tmp%10)%10);
		}while(tmp != N);
		
		System.out.println(cnt);
	}
	
}
