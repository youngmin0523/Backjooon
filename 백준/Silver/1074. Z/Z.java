import java.util.*;
import java.io.*;

public class Main {
	static int N, r, c, size, cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		size = (int)Math.pow(2,N);
		
		recursion(size, r, c);
		System.out.println(cnt);
	}
	static void recursion(int size, int r, int c) {
		if(size == 2) {
			if(r == 0) {
				if(c == 1) {
					cnt += 1;
				}
			}
			else {
				if(c == 0) {
					cnt += 2;
				}
				else {
					cnt += 3;
				}
			}
			return;
		}
		
		int half = size/2;
		if(r < half) {
			if(c < half) {
				recursion(half, r, c);
			}
			else {
				cnt += half*half;
				recursion(half, r, c-half);
			}
		}
		else {
			if(c < half) {
				cnt += half*half*2;
				recursion(half, r-half, c);
			}
			else {
				cnt += half*half*3;
				recursion(half, r-half, c-half);
			}
		}
		
	}
}
