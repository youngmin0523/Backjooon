import java.io.*;
import java.util.*;

public class Main {
	static String[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					int i = 0;
					while(true) {
						if(i >= o1.length() || i >= o2.length()) {
							break;
						}
						if(o1.charAt(i) == o2.charAt(i)) {
							i++;
						}
						else {
							return o1.charAt(i) - o2.charAt(i);
						}
					}
					return 0;
				}
				else
					return o1.length() - o2.length();
			}
		});
		
		String tmp = arr[0];
		System.out.println(tmp);
		for(int i = 1; i < arr.length; i++) {
			if(!tmp.equals(arr[i])) {
				System.out.println(arr[i]);
			}
			tmp = arr[i];
		}
	}
}