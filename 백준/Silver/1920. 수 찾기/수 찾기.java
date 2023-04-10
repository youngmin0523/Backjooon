import java.util.*;
import java.io.*;
 
public class Main {
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	int left = 0, right = N-1;
        	int middle;
        	while(left <= right) {
        		middle = (left+right)/2;
        		if(tmp == arr[middle]) {
        			break;
        		}
        		else if(tmp < arr[middle]) {
        			right = middle-1;
        		}
        		else {
        			left = middle+1;
        		}
        	}
        	if(left <= right) {
        		sb.append(1);
        	}
        	else {
        		sb.append(0);
        	}
        	sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}    