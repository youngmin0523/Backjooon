import java.util.*;
import java.io.*;
 
public class Main {
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int length[] = new int[3];
        while(true) {
        	st = new StringTokenizer(br.readLine());
        	length[0] = Integer.parseInt(st.nextToken());
        	length[1] = Integer.parseInt(st.nextToken());
        	length[2] = Integer.parseInt(st.nextToken());
        	if(length[0] == 0) {
        		break;
        	}
        	int index = 0;
        	if(length[1] > length[index]) {
        		index = 1;
        	}
        	if(length[2] > length[index]) {
        		index = 2;
        	}
        	if(length[index]*length[index] == length[(index+1)%3]*length[(index+1)%3] + length[(index+2)%3]*length[(index+2)%3]) {
        		sb.append("right").append('\n');
        	}
        	else {
        		sb.append("wrong").append('\n');
        	}
        }
        System.out.println(sb.toString());
    }
}    