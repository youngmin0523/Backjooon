import java.io.*;
import java.util.*;

public class Main {
	static int S, P, res;
	static int[] cnt = new int[4];
	static String DNA = "ACGT";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 0);
		map.put('G', 0);
		map.put('T', 0);
		
		for(int i = 0; i < P; i++) {
			map.put(str.charAt(i), map.get(str.charAt(i))+1);
		}
		if(exe(map)) res++;
		
		for(int i = 1; i <= S-P; i++) {
			char left = str.charAt(i-1);
			char right = str.charAt(i-1+P);
			
			map.put(left, map.get(left)-1);
			map.put(right, map.get(right)+1);
			if(exe(map)) res++;
		}
		
		System.out.println(res);
	}
	static boolean exe(Map<Character, Integer> map) {
		for(Character it: map.keySet()) {
			if(map.get(it) < cnt[DNA.indexOf(it)]) return false;
		}
		return true;
		
	}
}