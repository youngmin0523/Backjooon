import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K, A[][], selected[], min = Integer.MAX_VALUE;
	static Rotation[] rotation;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N+1][M+1];
		rotation = new Rotation[K];
		isSelected = new boolean[K];
		selected = new int[K];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rotation[i] = new Rotation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		perm(0);
		
		System.out.println(min);
	}
	static void perm(int cnt) {
		if(cnt == K) {
			int[][] arr = new int[N+1][M+1];
			for(int i = 0; i < N+1; i++) {
				arr[i] = Arrays.copyOfRange(A[i], 0, M+1);
			}
					
			getMin(arr);
			return;
		}
		for(int i = 0; i < K; i++) {
			if(isSelected[i]) continue;
			selected[cnt] = i;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	static void getMin(int[][] arr) {
		for(int i = 0; i < K; i++) {
			Rotation rot = rotation[selected[i]];
			
			for(int j = rot.s; j > 0; j--) {
				int tmp = arr[rot.r-j][rot.c-j];
				for(int k = 0; k < 2*j; k++) {
					arr[rot.r-j+k][rot.c-j] = arr[rot.r-j+k+1][rot.c-j];
				}
				for(int k = 0; k < 2*j; k++) {
					arr[rot.r+j][rot.c-j+k] = arr[rot.r+j][rot.c-j+k+1];
				}
				for(int k = 0; k < 2*j; k++) {
					arr[rot.r+j-k][rot.c+j] = arr[rot.r+j-k-1][rot.c+j];
				}
				for(int k = 0; k < 2*j-1; k++) {
					arr[rot.r-j][rot.c+j-k] = arr[rot.r-j][rot.c+j-k-1];
				}
				arr[rot.r-j][rot.c-j+1] = tmp;
			}
		}
		int tmp;
		for(int i = 1; i <= N; i++) {
			tmp = 0;
			for(int j = 1; j <= M; j++) {
				tmp += arr[i][j];
			}
			if(min > tmp) {
				min = tmp;
			}
		}
	}
	static class Rotation{
		int r, c, s;
		Rotation(int r, int c, int s){
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
