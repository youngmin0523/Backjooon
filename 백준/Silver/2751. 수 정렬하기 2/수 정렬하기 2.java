import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		for(int i = 0; i < N; i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb.toString());
    }
}