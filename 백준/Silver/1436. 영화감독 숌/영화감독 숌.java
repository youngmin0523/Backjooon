import java.util.*;
import java.io.*;
 
public class Main {
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
		int cnt = 0;
        int i;
		for(i = 666; cnt < N; i++) {
			if(String.valueOf(i).contains("666")) {
				cnt++;
			}
		}
		System.out.println(i-1);
    }
}    