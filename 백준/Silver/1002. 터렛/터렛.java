import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int result;
			double distance = Math.abs(Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)));
			double subtract = r1 > r2 ? r1 - r2 : r2 - r1;
		        
	        if(distance == 0 && r1 == r2) result = -1;
	        else if(distance < r1 + r2 && (subtract < distance)) result = 2;
	        else if(distance == r1 + r2 || distance == subtract) result = 1;
	        else result = 0;
	        System.out.println(result);
		}
	}
}