import java.io.*;
import java.util.*;

class Main {
	
	static int N, table[][], start, min;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        table = new int[N][N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine().trim(), " ");
        	for(int j = 0; j < N; j++) {
        		table[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        min = Integer.MAX_VALUE;
        for(start = 0; start < N; start++) {
        	dfs(start, 0, (1<<start));
        }
        System.out.println(min);
    }
    static void dfs(int city, int cost, int visited) {
    	if(cost >= min) return;
    	if(visited == (1<<N)-1 && table[city][start] != 0) {
    		min = Math.min(min, cost+table[city][start]);
    		return;
    	}
    	
    	for(int i = 0; i < N; i++) {
    		if((visited & (1<<i)) == 0 && table[city][i] != 0) {
    			dfs(i, cost+table[city][i], visited | (1<<i));
    		}
    	}
    }
}