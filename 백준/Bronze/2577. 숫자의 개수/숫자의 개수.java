import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int mul = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
		int[] cnt = new int[10];
		int tmp;
		while (mul != 0) {
			tmp = mul % 10;
			cnt[tmp]++;
			mul /= 10;
		}
		for (int i = 0; i < 10; i++) {
			sb.append(cnt[i]).append("\n");
		}
		System.out.println(sb);
	}
}
