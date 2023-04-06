import java.io.*;
import java.util.*;

public class Main {

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Door {
		int r, c;
		char num;
		
		public Door(int r, int c, char num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	
	static int h, w, keys, res;
	static char map[][];
	static String str;
	static List<Door> doorList;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[] keyList = new boolean[26];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2];
			doorList = new ArrayList<>();
			res = 0; keys = 0;
			Arrays.fill(keyList, false);
			
			for(int i = 1; i <= h; i++) {
				str = br.readLine();
				for(int j = 1; j <= w; j++) {
					map[i][j] = str.charAt(j-1);
				}
			}
			
			str = br.readLine();
			if(!str.equals("0")) {
				for(int i = 0; i < str.length(); i++) {
//					keys |= 1 << (str.charAt(i)-'a');
					keyList[str.charAt(i)-'a'] = true;
				}
			}
			bfs();

			sb.append(res).append('\n');
		}
		System.out.println(sb.toString());
	}
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		boolean visited[][] = new boolean[h+2][w+2];
		q.offer(new Pos(0, 0));
		visited[0][0] = true;
		
		Pos curr;
		int nr, nc;
		while(!q.isEmpty()) {
			while(!q.isEmpty()) {
				curr = q.poll();
				for(int d = 0; d < 4; d++) {
					nr = curr.r + dr[d];
					nc = curr.c + dc[d];
					
					if(!range(nr, nc) || visited[nr][nc]) continue;
					if(map[nr][nc] == '.' || map[nr][nc] == '\0') {
						q.offer(new Pos(nr, nc));
						visited[nr][nc] = true;
					}
					else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
//						keys |= 1<<(map[nr][nc]-'a');
						keyList[map[nr][nc]-'a'] = true;
						q.offer(new Pos(nr, nc));
						visited[nr][nc] = true;
					}
					else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {
						doorList.add(new Door(nr, nc, map[nr][nc]));
					}
					else if(map[nr][nc] == '$') {
						q.offer(new Pos(nr, nc));
						visited[nr][nc] = true;
						map[nr][nc] = '.';
						res++;
					}
				}
			}
			for(int i = 0; i < doorList.size(); i++) {
				Door door = doorList.get(i);
//				if(((1<<(door.num-'A')) & keys) == 1) {
				if(keyList[door.num-'A']) {
					q.offer(new Pos(door.r, door.c));
					visited[door.r][door.c] = true;
					doorList.remove(i);
					i--;
				}
			}
		}
	}
	static boolean range(int r, int c) {
		return r >= 0 && r < h+2 && c >= 0 && c < w+2;
	}
}
