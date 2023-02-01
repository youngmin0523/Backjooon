import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int i, j;
		
		st = new StringTokenizer(br.readLine());
		for(int k = 0; k < N; k++) {
			if(k > 0)
				arr[k] = arr[k-1] + Integer.parseInt(st.nextToken());
			else
				arr[k] = Integer.parseInt(st.nextToken());
		}
		for(int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			if(i > 1)
				System.out.println(arr[j-1] - arr[i-2]);
			else
				System.out.println(arr[j-1]);
		}
	}
}
