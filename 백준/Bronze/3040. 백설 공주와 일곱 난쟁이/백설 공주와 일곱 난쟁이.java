import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int arr[];
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		arr = new int[9];
		isSelected = new boolean[9];
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0, 0);
		System.out.println(sb);
		
	}
	static void comb(int cnt, int i, int sum) {
		if(sum > 100) return;
		if(cnt == 7) {
			if(sum == 100) {
				for(int j = 0; j < 9; j++) {
					if(isSelected[j]) {
						sb.append(arr[j]).append("\n");
					}
				}
			}
			return;
		}
		if(i >= 9) return;
		isSelected[i] = true;
		comb(cnt+1, i+1, sum+arr[i]);
		isSelected[i] = false;
		comb(cnt, i+1, sum);
	}
}
