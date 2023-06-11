import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] humans = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			humans[i] = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for(int i=0;i<N;i++) {
			int tmp = humans[i];
			for(int j=i+1;j<N;j++) {
				if(tmp==humans[j]) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}