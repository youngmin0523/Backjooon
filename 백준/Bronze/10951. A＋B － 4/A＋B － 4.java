import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int A, B;
		String str;
		
		while(true) {
			str = br.readLine();
			if(str == null) break;
			st = new StringTokenizer(str);
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			sb.append(A+B).append("\n");
			
		}
		System.out.println(sb);
	}
}
