import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE; 
		int min = Integer.MAX_VALUE;
		int tmp;
		
		for(int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			if(max < tmp) max = tmp;
			if(min > tmp) min = tmp;
		}
		System.out.println(min + " " + max);
	}
	
}
