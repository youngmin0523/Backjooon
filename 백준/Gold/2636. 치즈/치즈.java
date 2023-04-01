import java.util.*;
import java.io.*;
 
public class Main {
    
	static int N, M, cheese, map[][];
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N][M];
        cheese = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
                if(map[i][j] == 1) cheese++;
            }
        }
        
        int cheeseCount = 0;
        int time = 0;
        while(cheese != 0) {
            cheeseCount = cheese;
            time++;
            visited = new boolean[N][M];
            bfs();
        }
        System.out.println(time);
        System.out.println(cheeseCount);
    }
    
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];
                
                if(range(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if(map[nr][nc] == 0) {
                        q.offer(new int[] {nr, nc});
                    } else {
                        cheese--;
                        map[nr][nc] = 0;
                    }
                }
            }
        }
    }
    static boolean range(int r, int c) {
    	return r >= 0 && r < N && c >= 0 && c < M;
    }
}    