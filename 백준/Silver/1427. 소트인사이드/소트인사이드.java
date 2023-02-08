import java.io.*;
import java.util.*;

public class Main {
	static int arr[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		arr = new int[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - '0';
		}
		Arrays.sort(arr);
		for(int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
	}
}