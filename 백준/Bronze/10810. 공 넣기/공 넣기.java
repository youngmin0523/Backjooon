import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] basket = new int[N+1];
        for(int x = 0; x < M; x++) {
        	st = new StringTokenizer(br.readLine());
        	int i = Integer.parseInt(st.nextToken());
        	int j = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	
        	for(int y = i; y <= j; y++) {
        		basket[y] = k;
        	}
        }
        for(int i = 1; i <= N; i++) {
        	System.out.print(basket[i] + " ");
        }
    }
}