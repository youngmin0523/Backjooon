import java.util.*;
import java.io.*;
 
public class Main {
	
	static int N, K, arr[];
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        
        long max = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		max++;
		long min = 0; 
		long mid = 0; 
		while (min < max) { 
			mid = (max + min) / 2;
			long count = 0;
			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}
			if(count < N) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
    }
}    