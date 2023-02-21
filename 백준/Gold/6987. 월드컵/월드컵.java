import java.io.*;
import java.util.*;

public class Main {
	static int N, table[][], match[], res, matches[][], size;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		table = new int[6][3];
		match = new int[2];
		matches = new int[15][2];
		
		// 6 team 15 match
		comb(0, 0);
		for(int tc = 1; tc <= 4; tc++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 15match dfs
			dfs(0);
			sb.append(res).append(" ");
		}
		System.out.println(sb);
	}
	static void dfs(int cnt) {
		// 15 match complete
		if(cnt == 15) {
			boolean flag = true;
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					if(table[i][j] != 0) {
						flag = false;
					}
				}
			}
			if(flag) {
				res = 1;
			}
			return;
		}
		for(int i = 0; i < 3; i++) {
			table[matches[cnt][0]][i]--;
			table[matches[cnt][1]][2-i]--;
			if(table[matches[cnt][0]][i] >= 0 &&
					table[matches[cnt][1]][2-i] >= 0) {
				dfs(cnt+1);
			}
			table[matches[cnt][0]][i]++;
			table[matches[cnt][1]][2-i]++;
		}
	}
	static void comb(int cnt, int start) {
		if(cnt == 2) {
			matches[size++] = new int[] {match[0], match[1]};
			return;
		}
		for(int i = start; i < 6; i++) {
			match[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
}
