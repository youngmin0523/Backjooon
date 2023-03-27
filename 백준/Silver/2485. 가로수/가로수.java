import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int arr[] = new int[N];
        
        for(int i = 0; i< N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        int x = arr[0];
        int y = arr[1];
        int z = y -x;
        for(int i = 2; i < N; i++) {
        	x = y;
        	y = arr[i];
        	z = gcd(y-x, z);
        }
        
        int cnt = 0;
        x = arr[0];
        int index = 1;
        
        while(true) {
        	if(index == N) {
        		break;
        	}
        	x += z;
        	if(x == arr[index]) {
        		index++;
        	}
        	else {
        		cnt++;
        	}
        }
        System.out.println(cnt);
    }
    static int gcd(int A, int B) {
    	
    	while(B != 0) {
    		int tmp = A%B;
    		A = B;
    		B = tmp;
    	}
    	return A;
    }
}