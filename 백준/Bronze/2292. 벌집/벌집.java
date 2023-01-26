import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int i = 1, j = 1;
		
		while(true) {
			if(N >= i && N <= j) break;
			i = j +1;
			j = i + 6*cnt - 1;
			cnt++;
		}
		System.out.println(cnt);
	}
}
