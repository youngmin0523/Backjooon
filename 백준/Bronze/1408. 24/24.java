import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int curr, start, res;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		curr = (h * 3600) + (m * 60) + s;
		
		st = new StringTokenizer(br.readLine(), ":");
		h = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		start = (h * 3600) + (m * 60) + s;
		
		if(start > curr) {
			res = start - curr;
		}
		else {
			res = (24 * 3600) - (curr - start);
		}
		System.out.printf("%02d:%02d:%02d", (res / 3600), ((res / 60) % 60), (res % 60));
	}
}