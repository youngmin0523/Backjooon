import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, int[]> map = new HashMap<>();
		map.put("black", new int[] {0, 1});
		map.put("brown", new int[] {1, 10});
		map.put("red", new int[] {2, 100});
		map.put("orange", new int[] {3, 1000});
		map.put("yellow", new int[] {4, 10000});
		map.put("green", new int[] {5, 100000});
		map.put("blue", new int[] {6, 1000000});
		map.put("violet", new int[] {7, 10000000});
		map.put("grey", new int[] {8, 100000000});
		map.put("white", new int[] {9, 1000000000});
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();

		String sum = ""+map.get(str1)[0] + map.get(str2)[0];
		long res = (long)Integer.parseInt(sum) * (long)map.get(str3)[1];
		System.out.println(res);
	}

}
