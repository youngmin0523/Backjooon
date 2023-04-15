import java.util.*;
import java.io.*;
 
public class Main {
	
	static int N, arr[][];
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> s = new Stack<>();
        String str;
        loop:while(true) {
        	s.clear();
        	str = br.readLine();
        	if(str.equals(".")) {
        		break;
        	}
        	char tmp;
        	for(int i = 0; i < str.length(); i++) {
        		switch(tmp = str.charAt(i)) {
        		case '(':
        			s.push(tmp);
        			break;
        		case ')':
        			if(s.isEmpty() || s.peek() != '(') {
        				sb.append("no").append('\n');
        				continue loop;
        			}
        			else {
        				s.pop();
        			}
        			break;
        		case '[':
        			s.push(tmp);
        			break;
        		case ']':
        			if(s.isEmpty() || s.peek() != '[') {
        				sb.append("no").append('\n');
        				continue loop;
        			}
        			else {
        				s.pop();
        			}
        			break;
        		}
        	}
        	if(s.isEmpty()) {
        		sb.append("yes");
        	}
        	else {
        		sb.append("no");
        	}
        	sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}    