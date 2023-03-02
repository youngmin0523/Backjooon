import java.io.*;
import java.util.*;

public class Main {
	static class Shark {
		int r, c, s, d, z;
		boolean death;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static int R, C, M, r, c, s, d, z, res;
	static final int dr[] = {0, -1, 1, 0, 0};
	static final int dc[] = {0, 0, 0, 1, -1};
	static Shark[][] map;
	static List<Shark> sharkList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R+1][C+1];
		sharkList = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r, c, s, d, z);
			sharkList.add(map[r][c]);
		}

		for(int col = 1; col <= C; col++) {
			for(int row = 1; row <= R; row++) {
				if(map[row][col] != null) {
					res += map[row][col].z;
					//System.out.println(res);
					sharkList.remove(sharkList.indexOf(map[row][col]));
					map[row][col] = null;
					break;
				}
			}
			moveShark();
			setMap();
//			for(int i = 1; i <= R; i++) {
//				for(int j = 1; j <= C; j++) {
//					System.out.print((map[i][j]!=null?1:0) + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		System.out.println(res);
	}
	static void setMap() {
//		Arrays.fill(map, null);
		map = new Shark[R+1][C+1];
		for(Shark shark : sharkList) {
			if(shark.death) continue;
			if(map[shark.r][shark.c] == null) {
				map[shark.r][shark.c] = shark;
			}
			else {
				if(map[shark.r][shark.c].z < shark.z) {
					map[shark.r][shark.c].death = true;
					map[shark.r][shark.c] = shark;
				}
				else {
					shark.death = true;
				}
			}
		}
	}
	static void moveShark() {
		for(Shark shark : sharkList) {
			if(shark.death) continue;
			int mod, moveCnt;
			switch(shark.d) {
			case 1:
				mod = (R-1)*2;
				moveCnt = shark.s%mod;
				move(0, shark, moveCnt);
				break;
			case 2:
				mod = (R-1)*2;
				moveCnt = shark.s%mod;
				move(0, shark, moveCnt);
				break;
			case 3:
				mod = (C-1)*2;
				moveCnt = shark.s%mod;
				move(0, shark, moveCnt);
				break;
			case 4:
				mod = (C-1)*2;
				moveCnt = shark.s%mod;
				move(0, shark, moveCnt);
			}
		}
	}
	static void move(int cnt, Shark shark, int moveCnt) {
		if(cnt == moveCnt) {
			return;
		}
		int nr = shark.r + dr[shark.d];
		int nc = shark.c + dc[shark.d];
		if(range(nr, nc)) {
			shark.r = nr;
			shark.c = nc;
			move(cnt+1, shark, moveCnt);
		}
		else {
			if(shark.d == 1) {
				shark.d = 2;
			}
			else if(shark.d == 2) {
				shark.d = 1;
			}
			else if(shark.d == 3) {
				shark.d = 4;
			}
			else {
				shark.d = 3;
			}
			move(cnt, shark, moveCnt);
		}
	}
	static boolean range(int r, int c) {
		if(r >= 1 && r <= R && c >= 1 && c <= C) return true;
		return false;
	}
}
