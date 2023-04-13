import java.util.*;
import java.io.*;
 
public class Main {
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        int res = 0, r = 1;
        int MOD = 1234567891;
        for(int i = 0; i < str.length(); i++) {
        	res += (str.charAt(i)-'a'+1)*r%MOD;
        	r = (r*31)%MOD;
        }
        System.out.println(res);
    }
}    