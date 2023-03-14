import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int cnt = 1;
        for(int i = 1; i <= N; i++) {
        	if(N%i == 0) {
        		if(cnt == K) {
        			System.out.println(i);
        			return;
        		}
        		cnt++;
        	}
        }
        System.out.println(0);
    }
}