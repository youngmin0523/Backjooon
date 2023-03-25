import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        
        int x = a1*n0 + a0;
        int y = c*n0;
        
        if(a1 <= c && x <= y) {
        	System.out.println(1);
        }
        else {
        	System.out.println(0);
        }
    }
}