import java.io.*;
import java.util.*;

public class Main {
	static int N, K, cnt;
	static int[] A, tmp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N];
		tmp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		merge_sort(0, A.length-1);
		if(cnt < K) {
			System.out.println(-1);
		}
	}
	static void merge_sort(int p, int r) {
		if(p < r) {
			int q = (p+r)/2;
			merge_sort(p, q);
			merge_sort(q+1, r);
			merge(p, q, r);
		}
	}
	static void merge(int p, int q, int r) {
		int i = p, j = q+1, t = 0;
		while(i <= q && j <= r) {
			if(A[i] <= A[j]) {
				tmp[t++] = A[i++];
			}
			else {
				tmp[t++]=A[j++];
			}
		}
		while(i <= q) {
			tmp[t++] = A[i++];
		}
		while(j <= r) {
			tmp[t++] = A[j++];
		}
		i = p; t = 0;
		while(i <= r) {
			cnt++;
			if(cnt == K) {
				System.out.println(tmp[t]);
			}
			A[i++] = tmp[t++];
		}
	}
}