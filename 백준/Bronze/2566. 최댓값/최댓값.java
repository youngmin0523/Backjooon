import java.io.*;
import java.util.*;

public class Main {
	static int tmp, max, x = 1, y = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 9; j++) {
				tmp = Integer.parseInt(st.nextToken());
				if(tmp > max) {
					max = tmp;
					x = i; y = j;
				}
			}
		}
		System.out.println(max);
		System.out.println(x + " " + y);
	}
}
