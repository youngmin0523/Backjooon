import java.util.*;
import java.io.*;
 
public class Main {
    
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, matrix[][];
	static Pos[] places;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	matrix = new int[N+2][N+2];
        	places = new Pos[N+2];
        	
        	for(int i = 0; i < N+2; i++) {
        		st = new StringTokenizer(br.readLine());
        		places[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	}
        	for(int i = 0; i < N+2; i++) {
        		for(int j = 0; j < N+2; j++) {
        			if(i == j) continue;
        			int distance = Math.abs(places[i].x - places[j].x) + Math.abs(places[i].y - places[j].y);
        			if(distance > 1000) {
        				matrix[i][j] = 1000;
        			}
        			else {
        				matrix[i][j] = 1;
        			}
        		}
        	}
        	for(int k = 0; k < N+2; k++) {
        		for(int i = 0; i < N+2; i++) {
        			if(i == k) continue;
        			for(int j = 0; j < N+2; j++) {
        				if(j == i || j == k) continue;
        				matrix[i][j] = Math.min(matrix[i][k] + matrix[k][j], matrix[i][j]);
        			}
        		}
        	}
        	sb.append(matrix[0][N+1]==1000?"sad":"happy").append('\n');
        }
        System.out.println(sb.toString());
    }
}    