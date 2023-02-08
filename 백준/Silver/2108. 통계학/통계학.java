import java.io.*;
import java.util.*;

public class Main {
	static int arr[], cnt[];
	static int maxCnt;
	static double sum;
	static List<Integer> max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		cnt = new int[8001];
		max = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			cnt[arr[i]+4000]++;
		}
		
		System.out.println((int)Math.round(sum/N));
		
		Arrays.sort(arr);
		System.out.println(arr[N/2]);
		
		for(int i = 0; i <= 8000; i++) {
			if(maxCnt < cnt[i]) {
				maxCnt = cnt[i];
			}
		}
		for(int i = 0; i <= 8000; i++) {
			if(maxCnt == cnt[i]) {
				max.add(i);
			}
		}
		
		if(max.size() > 1) {
			Collections.sort(max);
			System.out.println(max.get(1)-4000);
		}
		else {
			System.out.println(max.get(0)-4000);
		}
		System.out.println(arr[N-1]-arr[0]);
	}
}