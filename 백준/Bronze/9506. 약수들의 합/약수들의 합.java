import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        
        while(true) {
        	n = Integer.parseInt(br.readLine());
        	if(n == -1) {
        		break;
        	}
        	StringBuilder sb = new StringBuilder();
        	sb.append(n).append(" = 1");
        	int cnt = 0;
        	for(int i = 1; i < n; i++) {
        		if(n % i == 0) {
        			cnt += i;
        			if(i != 1) {
        				sb.append(" + ").append(i);
        			}
        		}
        	}
        	if(cnt == n) {
        		System.out.println(sb.toString());
        	}
        	else {
        		System.out.println(n + " is NOT perfect.");
        	}
        }
    }
}