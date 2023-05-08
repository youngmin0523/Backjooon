import java.io.*;
import java.util.*;


public class Main {
	
	static class Pos {
		int r, c;
		int state;
		int cnt;
		
		Pos(){
			
		}
		
		Pos(int r, int c, int state, int cnt){
			this.r = r;
			this.c = c;
			this.state = state;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", state=" + state + ", cnt=" + cnt + "]";
		}
	}
	
	static int N;
	static char[][] map;
	static Pos start = new Pos();
	static Pos end = new Pos();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		int start_cnt = 0, end_cnt = 0;
		int start_r[] = new int[3];
		int start_c[] = new int[3];
		int end_r[] = new int[3];
		int end_c[] = new int[3];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'B') {
					start_r[start_cnt] = i;
					start_c[start_cnt++] = j;
					start.r += i;
					start.c += j;
					map[i][j] = '0';
 				}
				if(map[i][j] == 'E') {
					end_r[end_cnt] = i;
					end_c[end_cnt++] = j;
					end.r += i;
					end.c += j;
					map[i][j] = '0';
 				}
			}
		}
		if(start_r[0] == start_r[1]) {
			start.state = 0; // 시작 상태 누워있다.
		}
		else {
			start.state = 1; // 시작 상태 서있다.
		}
		start.r /= 3; // 시작 행 좌표
		start.c /= 3; // 시작 열 좌표
		
		if(end_r[0] == end_r[1]) {
			end.state = 0; // 끝 상태 누워있다.
		}
		else {
			end.state = 1; // 끝 상태 서있다.
		}
		end.r /= 3; // 끝 행 좌표
		end.c /= 3; // 끝 열 좌표
		
		System.out.println(solve());
	}
	static int solve() { // bfs 최소단계 찾기
		Queue<Pos> q = new ArrayDeque<>();
		boolean visited[][][] = new boolean[N][N][2];
		q.offer(start);
		visited[start.r][start.c][start.state] = true;
		
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			if(curr.r == end.r && curr.c == end.c && curr.state == end.state) { // 도착지점과 같으면
				return curr.cnt; // cnt 리턴
			}
			
			if(curr.state == 0) { // 누워져 있으면
				if(range(curr.r-1, curr.c) && !visited[curr.r-1][curr.c][curr.state]) { // 상
					boolean flag = true;
					for(int i = -1; i <= 1; i++) {
						if(map[curr.r-1][curr.c+i] == '1') {
							flag = false;
						}
					}
					if(flag) {
						q.offer(new Pos(curr.r-1, curr.c, curr.state, curr.cnt+1));
						visited[curr.r-1][curr.c][curr.state] = true;
					}
				}
				if(range(curr.r+1, curr.c) && !visited[curr.r+1][curr.c][curr.state]) { // 하
					boolean flag = true;
					for(int i = -1; i <= 1; i++) {
						if(map[curr.r+1][curr.c+i] == '1') {
							flag = false;
						}
					}
					if(flag) {
						q.offer(new Pos(curr.r+1, curr.c, curr.state, curr.cnt+1));
						visited[curr.r+1][curr.c][curr.state] = true;
					}
				}
				if(range(curr.r, curr.c-2) && !visited[curr.r][curr.c-1][curr.state] 
						&& map[curr.r][curr.c-2] == '0') { // 좌
					q.offer(new Pos(curr.r, curr.c-1, curr.state, curr.cnt+1));
					visited[curr.r][curr.c-1][curr.state] = true;
				}
				if(range(curr.r, curr.c+2) && !visited[curr.r][curr.c+1][curr.state] 
						&& map[curr.r][curr.c+2] == '0') { // 우
					q.offer(new Pos(curr.r, curr.c+1, curr.state, curr.cnt+1));
					visited[curr.r][curr.c+1][curr.state] = true;
				}
				if(range(curr.r-1, curr.c) && range(curr.r+1, curr.c)  // 회전
						&& !visited[curr.r][curr.c][1]) {
					boolean flag = true;
					for(int i = -1; i <= 1; i++) {
						if(map[curr.r-1][curr.c+i] == '1') {
							flag = false;
							break;
						}
						if(map[curr.r+1][curr.c+i] == '1') {
							flag = false;
							break;
						}
					}
					if(flag) {
						q.offer(new Pos(curr.r, curr.c, 1, curr.cnt+1));
						visited[curr.r][curr.c][1] = true;
					}
				}
			}
			else { // 세워져 있으면
				if(range(curr.r-2, curr.c) && !visited[curr.r-1][curr.c][curr.state] 
						&& map[curr.r-2][curr.c] == '0') { // 상
					q.offer(new Pos(curr.r-1, curr.c, curr.state, curr.cnt+1));
					visited[curr.r-1][curr.c][curr.state] = true;
				}
				if(range(curr.r+2, curr.c) && !visited[curr.r+1][curr.c][curr.state] 
						&& map[curr.r+2][curr.c] == '0') { // 하
					q.offer(new Pos(curr.r+1, curr.c, curr.state, curr.cnt+1));
					visited[curr.r+1][curr.c][curr.state] = true;
				}
				if(range(curr.r, curr.c-1) && !visited[curr.r][curr.c-1][curr.state]) { // 좌
					boolean flag = true;
					for(int i = -1; i <= 1; i++) {
						if(map[curr.r+i][curr.c-1] == '1') {
							flag = false;
						}
					}
					if(flag) {
						q.offer(new Pos(curr.r, curr.c-1, curr.state, curr.cnt+1));
						visited[curr.r][curr.c-1][curr.state] = true;
					}
				}
				if(range(curr.r, curr.c+1) && !visited[curr.r][curr.c+1][curr.state]) { // 우
					boolean flag = true;
					for(int i = -1; i <= 1; i++) {
						if(map[curr.r+i][curr.c+1] == '1') {
							flag = false;
						}
					}
					if(flag) {
						q.offer(new Pos(curr.r, curr.c+1, curr.state, curr.cnt+1));
						visited[curr.r][curr.c+1][curr.state] = true;
					}
				}
				if(range(curr.r, curr.c-1) && range(curr.r, curr.c+1) // 회전
						&& !visited[curr.r][curr.c][0]) {
					boolean flag = true;
					for(int i = -1; i <= 1; i++) {
						if(map[curr.r+i][curr.c-1] == '1') {
							flag = false;
							break;
						}
						if(map[curr.r+i][curr.c+1] == '1') {
							flag = false;
							break;
						}
					}
					if(flag) {
						q.offer(new Pos(curr.r, curr.c, 0, curr.cnt+1));
						visited[curr.r][curr.c][0] = true;
					}
				}
			}
		}
		return 0; // 목표 지점까지 도달하지 못할 시 0 리턴
	}
	static boolean range(int r, int c) { // 범위 내에 있는지 확인
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
