import java.util.*;
import java.io.*;
 
public class Main {
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int min = Math.min(x-0, w-x);
        min = Math.min(min, h-y);
        min = Math.min(min, y-0);
        System.out.println(min);
    }
}    