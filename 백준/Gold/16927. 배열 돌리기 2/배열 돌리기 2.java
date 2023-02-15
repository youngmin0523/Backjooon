import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, R, A[][];
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotation();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void rotation() {
		int index = 0;
		int a = N, b = M;
		int length = Math.min(a,  b);
		while(true) {
			int r = R % (2*a + 2*b - 4);
			for(int j = 0; j < r; j++) {
				int tmp = A[1+index][1+index];
				for(int i = 1+index; i < M-index; i++) {
					A[1+index][i] = A[1+index][i+1];
				}
				for(int i  = 1+index; i < N-index; i++) {
					A[i][M-index] = A[i+1][M-index];
				}
				for(int i = M-index; i > 1+index; i--) {
					A[N-index][i] = A[N-index][i-1];
				}
				for(int i = N-index; i > 2+index; i--) {
					A[i][1+index] = A[i-1][1+index];
				}
				A[2+index][1+index] = tmp;
			}
			a -= 2; b -= 2;
			if(++index >= (double)length/2) {
				break;
			}
		}
	}
	static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
