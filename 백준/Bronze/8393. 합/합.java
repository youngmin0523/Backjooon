import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int res = 0;
		
		for(int i = 1; i <= n; i++)
			res += i;
		System.out.println(res);
	}
}
