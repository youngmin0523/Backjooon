import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		int H, W, N, floor, room;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			if(N%H == 0) {
				floor = H;
				room = N/H;
			}
			else {
				floor = N%H;
				room = N/H+1;
			}
			
			sb = new StringBuilder(String.valueOf(floor));
			if(room < 10)
				sb.append("0").append(room);
			else
				sb.append(room);
			
			System.out.println(sb);
		}
	}
}
