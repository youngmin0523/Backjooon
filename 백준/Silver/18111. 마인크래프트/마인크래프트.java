import java.io.*;
import java.util.*;
 
public class Main {
 
	static int N, M, B, arr[], min, max, res[];
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new int[N*M];
		min = 256; max = 0;
		res = new int[2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i*M+j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i*M+j]);
				max = Math.max(max, arr[i*M+j]);
			}
		}
		Arrays.sort(arr);
		for(int i = 0; i < N*M; i++) {
			res[0] += arr[i]-min;
		}
		res[0] *= 2;
		res[1] = min;
		for(int height = min+1; height <= max; height++) {
			int high = 0, low = 0;
			for(int i = N*M-1; i >= 0; i--) {
				if(arr[i] < height ) {
					low += height-arr[i];
				}
				else if(arr[i] > height) {
					high += arr[i]-height;
				}
			}
			int tmp = 2*high+low;
			if(high+B >= low && tmp <= res[0]) {
				res[0] = tmp;
				res[1] = height;
			}
		}
		System.out.println(res[0] + " " + res[1]);
	}
}