import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B =Integer.parseInt(st.nextToken());
			sb.append("Case #").append(test_case).append(": ");
			sb.append(A).append(" + ").append(B).append(" = ").append(A+B);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
