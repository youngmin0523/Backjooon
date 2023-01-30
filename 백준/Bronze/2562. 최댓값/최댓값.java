import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int index = 0;
		int max = 0;
		int tmp;
		
		for(int i = 1; i <= 9; i++) {
			tmp = Integer.parseInt(br.readLine());
			if(max < tmp) {
				max = tmp;
				index = i;
			}
		}
		System.out.println(max + "\n" + index);
	}
	
}
