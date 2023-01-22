import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tmp;
		int[] chess = {1, 1, 2, 2, 2, 8};
		
		for(int i = 0; i < 6; i++) {
			tmp = Integer.parseInt(st.nextToken());
			System.out.print(chess[i] - tmp + " ");
		}	
	}
}
