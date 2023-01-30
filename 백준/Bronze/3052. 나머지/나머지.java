import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] remainder = new boolean[42];
		int tmp;
		int cnt = 0;
		
		for(int i = 0; i < 10; i++) {
			tmp = Integer.parseInt(br.readLine())%42;
			if(!remainder[tmp]) remainder[tmp] = true;
		}
		for(int i = 0; i < 42; i++) {
			if(remainder[i]) cnt++;
		}
		System.out.println(cnt);
	}
}
