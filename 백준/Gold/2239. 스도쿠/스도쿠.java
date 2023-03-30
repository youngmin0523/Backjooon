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
    	int visited = 0;
    	for(int i = 0; i < 9; i++) {
    		visited |= (1<<map[curr[0]][i]);
    		visited |= (1<<map[i][curr[1]]);
    	}
    	int r = curr[0]/3*3;
    	int c = curr[1]/3*3;
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			visited |= (1<<map[r+i][c+j]);
    		}
    	}
    	
    	for(int i = 1; i <= 9; i++) {
    		if((visited&(1<<i)) == 0) {
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