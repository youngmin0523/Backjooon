import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int x = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		}
		if( X == x) System.out.println("Yes");
		else System.out.println("No");
	}
}
