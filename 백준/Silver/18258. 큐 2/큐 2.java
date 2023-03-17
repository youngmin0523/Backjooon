import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	switch(st.nextToken()) {
        	case "push":
        		q.offer(Integer.parseInt(st.nextToken()));
        		break;
        	case "pop":
        		if(q.isEmpty()) {
        			sb.append(-1).append("\n");
        		}
        		else {
        			sb.append(q.poll()).append("\n");
        		}
        		break;
        	case "size":
        		sb.append(q.size()).append("\n");
        		break;
        	case "empty":
        		if(q.isEmpty()) {
        			sb.append(1).append("\n");
        		}
        		else {
        			sb.append(0).append("\n");
        		}
        		break;
        	case "front":
        		if(q.isEmpty()) {
        			sb.append(-1).append("\n");
        		}
        		else {
        			sb.append(q.peekFirst()).append("\n");
        		}
        		break;
        	case "back":
        		if(q.isEmpty()) {
        			sb.append(-1).append("\n");
        		}
        		else {
        			sb.append(q.peekLast()).append("\n");
        		}
        		break;
        	}
        }
        System.out.println(sb.toString());
    }
}