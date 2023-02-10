import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String postfix;
	static Map<Character, Integer> map;
	static ArrayDeque<Double> deq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new HashMap<>();
		deq = new ArrayDeque<>();

		N = Integer.parseInt(br.readLine());
		postfix = br.readLine();

		for (int i = 0; i < N; i++) {
			map.put((char)('A' + i), Integer.parseInt(br.readLine()));
		}
		
		for (int i = 0; i < postfix.length(); i++) {
			char tmp = postfix.charAt(i);
			if (map.containsKey(tmp)) {
				deq.push((double) map.get(tmp));
			} else {
				double b = deq.pop();
				double a = deq.pop();
				switch (tmp) {
				case '+':
					deq.push(a + b);
					break;
				case '-':
					deq.push(a - b);
					break;
				case '*':
					deq.push(a * b);
					break;
				case '/':
					deq.push(a / b);
				}
			}
		}
		System.out.printf("%.2f", deq.pop());

	}
}