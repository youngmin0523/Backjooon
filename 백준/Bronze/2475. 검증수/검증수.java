import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int res = 0;
		while(st.hasMoreTokens()) {
			int tmp = Integer.parseInt(st.nextToken());
			tmp = tmp * tmp;
			res += tmp;
		}
		System.out.println(res%10);
	}
}
