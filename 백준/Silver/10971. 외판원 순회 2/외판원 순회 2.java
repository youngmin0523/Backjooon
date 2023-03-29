import java.io.*;
import java.util.*;

class Main {
	
	static int N, table[][], start, min;
	static boolean visited[];
	
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
        visited = new boolean[N];
        for(start = 0; start < N; start++) {
        	visited[start] = true;
        	dfs(1, start, 0);
        	visited[start] = false;
        }
        System.out.println(min);
    }
    static void dfs(int cnt, int city, int cost) {
    	if(cnt == N && table[city][start] != 0) {
    		min = Math.min(min, cost+table[city][start]);
    		return;
    	}
    	
    	for(int i = 0; i < N; i++) {
    		if(!visited[i] && table[city][i] != 0) {
    			visited[i] = true;
    			dfs(cnt+1, i, cost+table[city][i]);
    			visited[i] = false;
    		}
    	}
    }
}