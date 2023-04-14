import java.util.*;
import java.io.*;
 
public class Main {
	
	static int N, arr[][];
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < N; i++) {
        	int cnt = 0;
        	for(int j = 0; j < N; j++) {
        		if(arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) {
        			cnt++;
        		}
        	}
        	sb.append(cnt+1).append(' ');
        }
        System.out.println(sb.toString());
        
    }
}    