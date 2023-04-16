import java.util.*;
import java.io.*;
 
public class Main {
	
	static int N;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        
        int curr = 0;
        for(int i = 0; i < N; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	if(tmp < curr) {
        		if(s.peek() != tmp) {
        			System.out.println("NO");
        			return;
        		}
        	}
        	else {
        		while(curr != tmp) {
        			s.push(++curr);
        			sb.append('+').append('\n');
        		}
        		curr = tmp;
        	}
        	s.pop();
        	sb.append('-').append('\n');
        }
        System.out.println(sb.toString());
    }
}    