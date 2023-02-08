import java.io.*;
import java.util.*;

public class Main {
	static int arr[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int [N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> 
		{
			if(o1[0] == o2[0])
				return o1[1] - o2[1];
			else
				return o1[0] - o2[0];
		});
		
		for(int[] it : arr) {
			System.out.println(it[0] + " " + it[1]);
		}
	}
}