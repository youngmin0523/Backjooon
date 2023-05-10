import java.io.*;
import java.util.*;
 
public class Main {
	
	static int N;
	static int map[][];
	static int arr[] = new int[3];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0, 0, N);
		for(int i = 0; i < 3; i++) {
			System.out.println(arr[i]);
		}
	}
	static void solve(int r, int c, int length) {
		for(int i = r; i < r+length; i++) {
			for(int j = c; j < c+length; j++) {
				if(map[i][j] != map[r][c]) {
					int new_length = length/3;
					for(int x = 0; x < 3; x++) {
						for(int y = 0; y < 3; y++) {
							solve(r+x*new_length, c+y*new_length, new_length);
						}
					}
					return;
				}
			}
		}
		arr[map[r][c]+1]++;
	}
}