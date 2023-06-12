import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1; i <= C; i++) {
			for(int j = 0; j < N; j++) {
				if(i%arr[j] == 0) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}