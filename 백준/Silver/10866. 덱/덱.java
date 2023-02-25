import java.io.*;
import java.util.*;

class Main {
	static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	switch(st.nextToken()) {
        	case "push_front":
        		deq.addFirst(Integer.parseInt(st.nextToken()));
        		break;
        	case "push_back":
        		deq.addLast(Integer.parseInt(st.nextToken()));
        		break;
        	case "pop_front":
        		sb.append(deq.isEmpty()?-1:deq.pollFirst()).append("\n");
        		break;
        	case "pop_back":
        		sb.append(deq.isEmpty()?-1:deq.pollLast()).append("\n");
        		break;
        	case "size":
        		sb.append(deq.size()).append("\n");
        		break;
        	case "empty":
        		sb.append(deq.isEmpty()?1:0).append("\n");
        		break;
        	case "front":
        		sb.append(deq.isEmpty()?-1:deq.peekFirst()).append("\n");
        		break;
        	case "back":
        		sb.append(deq.isEmpty()?-1:deq.peekLast()).append("\n");
        	}
        }
        
        System.out.println(sb);
    }
}