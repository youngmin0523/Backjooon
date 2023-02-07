import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			if(gender == 1) {
				for(int j = 1; j*index <= N; j++) {
					arr[j*index] = 1 - arr[j*index];
				}
			}
			else {
				arr[index] = 1 - arr[index];
				int tmp = 1;
				while(true) {
					if(index-tmp < 1 || index+tmp > N || arr[index-tmp] != arr[index+tmp]) {
						break;
					}
					else {
						arr[index-tmp] = 1 - arr[index-tmp];
						arr[index+tmp] = 1 - arr[index+tmp];
					}
					tmp++;
				}
			}
			
		}
		for(int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
			if(i%20 == 0) {
				System.out.println();
			}
		}
	}
}
