import java.io.*;
import java.util.*;

public class Main {
	static int N, cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}
	static void hanoi(int n, int from, int tmp, int to) {
		if(n <= 1){
			sb.append(from).append(" ").append(to).append("\n");
			cnt++;
			return;
		}
		hanoi(n-1, from, to, tmp);
		sb.append(from).append(" ").append(to).append("\n");
		cnt++;
		hanoi(n-1, tmp, from, to);
	}
}