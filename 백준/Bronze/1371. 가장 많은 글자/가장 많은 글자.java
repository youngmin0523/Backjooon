import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int[] arr = new int[26];
		while((str=br.readLine()) != null) {
			for(int i = 0; i < str.length(); i++) {
				char tmp = str.charAt(i);

				if(tmp >= 'a' && tmp <= 'z')
					arr[tmp-'a']++;
			}
		}
		int max = 0;
		for(int i = 0; i < 26; i++) {
			max = Math.max(max, arr[i]);
		}
		for(int i = 0; i < 26; i++) {
			if(arr[i] == max) {
				System.out.print((char)('a'+i));
			}
		}
	}
}