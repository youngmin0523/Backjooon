import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[51][51];
		boolean flag = true;
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		if(N == 1) {
			System.out.print(arr[0]);
		}
		else {
			for(int i = 0; i < arr[0].length; i++) {
				flag = true;
				for(int j = 0; j < N; j++) {
					if(arr[j][i] != arr[0][i]) {
						flag = false;
					}
					if(!flag) {
						arr[0][i] = '?';
					}
				}
			}
			System.out.print(arr[0]);
		}
	}
}