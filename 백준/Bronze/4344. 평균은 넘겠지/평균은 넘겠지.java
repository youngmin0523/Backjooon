import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int C = Integer.parseInt(br.readLine());
		int N, avg, cnt;
		int[] arr;
		
		for(int test_case = 1; test_case <= C; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N]; avg = 0; cnt = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				avg += arr[i];
			}
			avg /= N;
			for(int i = 0; i < N; i++) {
				if(arr[i] > avg) cnt++;
			}
			System.out.printf("%.3f", (double)cnt/N*100);
			System.out.println("%");
		}
	}
}
