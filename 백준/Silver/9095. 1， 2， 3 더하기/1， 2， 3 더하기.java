import java.io.*;
import java.util.*;
 
public class Main {
 
	static int N, res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			res = 0;
			solve(0, 0, 0);
			System.out.println(res);
		}
		
	}
	static void solve(int x, int y, int z) {
		if(x + 2*y + 3*z == N) {
			res++;
			return;
		}
		else if(x + 2*y + 3*z > N) {
			return;
		}
		solve(x+1, y, z);
		solve(x, y+1, z);
		solve(x, y, z+1);
	}
}