import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= N-i; j++) {
        		System.out.print(" ");
        	}
        	for(int j = 1; j <= (-1+i*2); j++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
        for(int i = N-1; i >= 1; i--) {
        	for(int j = 1; j <= N-i; j++) {
        		System.out.print(" ");
        	}
        	for(int j = 1; j <= (-1+i*2); j++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
        
    }
}