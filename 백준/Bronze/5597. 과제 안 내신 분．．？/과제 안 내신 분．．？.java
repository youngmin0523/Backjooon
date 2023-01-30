import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] submission = new boolean[31];
		
		for(int i = 1; i <= 28; i++) {
			submission[Integer.parseInt(br.readLine())] = true;
		}
		for(int i = 1; i <= 30; i++) {
			if(!submission[i]) System.out.println(i);
		}
	}
}
