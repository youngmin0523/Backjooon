import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		
		if(A >= 90) System.out.print("A");
		else if(A >= 80) System.out.print("B");
		else if(A >= 70) System.out.print("C");
		else if(A >= 60) System.out.print("D");
		else System.out.print("F");
	}
}
