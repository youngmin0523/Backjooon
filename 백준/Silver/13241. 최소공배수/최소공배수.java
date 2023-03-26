import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        long tmp;
        if(A >= B) {
        	tmp = gcd(A, B);
        }
        else {
        	tmp = gcd(B, A);
        }
        System.out.println(A*B/tmp);
    }
    static Long gcd(long A, long B) {
    	
    	while(B != 0) {
    		long tmp = A%B;
    		A = B;
    		B = tmp;
    	}
    	return A;
    }
}