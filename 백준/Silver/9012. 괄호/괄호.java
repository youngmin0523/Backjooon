import java.util.*;
import java.io.*;
 
public class Main {
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        Stack<Character> s = new Stack<>();
        
        loop1:for(int tc = 1; tc <= T; tc++) {
        	s.clear();
        	String str = br.readLine();
        	for(int i = 0; i < str.length(); i++) {
        		char tmp = str.charAt(i);
        		if(tmp == '(') {
        			s.push(tmp);
        		}
        		else {
        			if(s.isEmpty()) {
        				sb.append("NO").append('\n');
        				continue loop1;
        			}
        			else {
        				s.pop();
        			}
        		}
        	}
        	if(s.isEmpty()) {
        		sb.append("YES").append('\n');
        	}
        	else {
        		sb.append("NO").append('\n');
        	}
        }
        System.out.println(sb.toString());
    }
}    