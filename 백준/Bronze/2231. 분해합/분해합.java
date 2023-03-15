import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int i = 1;
        for(; i < N; i++) {
        	int tmp = i;
        	int sum = i;
        	
        	while(tmp != 0) {
        		sum += tmp%10;
        		tmp /= 10;
        	}
        	if(sum == N) {
        		System.out.println(i);
        		break;
        	}
        }
        if(i == N) {
        	System.out.println(0);
        }
    }
}