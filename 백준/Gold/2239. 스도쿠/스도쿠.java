import java.io.*;
import java.util.*;

class Main {
	
	static int map[][];
	static List<int[]> list;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        map = new int[9][9];
        list = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
        	String str = br.readLine();
        	for(int j = 0; j < 9; j++) {
        		map[i][j] = str.charAt(j) - '0';
        		if(map[i][j] == 0) {
        			list.add(new int[] {i, j});
        		}
        	}
        }
        boolean flag = solve(0);
        if(flag) {
        	for(int i = 0; i < 9; i++) {
        		for(int j =0 ; j < 9; j++) {
        			sb.append(map[i][j]);
        		}
        		sb.append('\n');
        	}
        	System.out.println(sb.toString());
        }
    }
    static boolean solve(int cnt) {
    	if(cnt == list.size()) {
    		return true;
    	}
    	
    	int[] curr = list.get(cnt);
    	boolean visited[] = new boolean[10];
    	for(int i = 0; i < 9; i++) {
    		visited[map[curr[0]][i]] = true;
    		visited[map[i][curr[1]]] = true;
    	}
    	int r = curr[0]/3*3;
    	int c = curr[1]/3*3;
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			visited[map[r+i][c+j]] = true;
    		}
    	}
    	
    	for(int i = 1; i <= 9; i++) {
    		if(!visited[i]) {
    			map[curr[0]][curr[1]] = i;
    			boolean flag = solve(cnt+1);
    			if(flag) {
    				return true;
    			}
    			map[curr[0]][curr[1]] = 0;
    		}
    	}
    	return false;
    }
}