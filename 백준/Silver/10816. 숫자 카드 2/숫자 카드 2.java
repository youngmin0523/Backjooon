import java.util.*;
import java.io.*;
 
public class Main {
	
	final static int NUM = 10000000;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[2*NUM+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	arr[Integer.parseInt(st.nextToken())+NUM]++;
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
        	sb.append(arr[Integer.parseInt(st.nextToken())+NUM]).append(' ');
        }
        System.out.println(sb.toString());
    }
}    