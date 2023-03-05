import java.io.*;
import java.util.*;

class Main {
	static int N, M, basket[];
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        basket = new int[N+1];
        for(int i = 1; i <= N; i++) {
        	basket[i] = i;
        }
        int i, j, tmp;
        for(int k = 0; k < M; k++) {
        	st = new StringTokenizer(br.readLine());
        	i = Integer.parseInt(st.nextToken());
        	j = Integer.parseInt(st.nextToken());
        	tmp = basket[i];
        	basket[i] = basket[j];
        	basket[j] = tmp;
        }
        for(int k = 1; k <= N; k++) {
        	sb.append(basket[k]).append(' ');
        }
        System.out.print(sb.toString());
    }
}