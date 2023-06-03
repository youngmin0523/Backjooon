import java.io.*;
import java.util.*;
 
public class Main {
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deq = new LinkedList<>();
        int cnt = 0;
        
        for(int i = 1; i <= N; i++) {
        	deq.offer(i);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
        	int target = Integer.parseInt(st.nextToken());
        	int index = deq.indexOf(target);
        	int half = deq.size()%2==0?deq.size()/2-1:deq.size()/2;
        	
        	if(index <= half) {
        		for(int j = 0; j < index; j++) {
        			int tmp = deq.pollFirst();
        			deq.offerLast(tmp);
        			cnt++;
        		}
        	}
        	else {
        		for(int j = 0; j < deq.size()-index; j++) {
        			int tmp = deq.pollLast();
        			deq.offerFirst(tmp);
        			cnt++;
        		}
        	}
        	deq.pollFirst();
        }
        System.out.println(cnt);
    }
}