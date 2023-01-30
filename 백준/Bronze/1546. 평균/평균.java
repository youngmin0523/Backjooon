import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		double avg = 0;
		double tmp, max = Double.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			tmp = Double.parseDouble(st.nextToken());
			avg += tmp;
			if(max < tmp) max = tmp;
		}
		avg /= N;
		System.out.println(avg/max*100);
	}
}
