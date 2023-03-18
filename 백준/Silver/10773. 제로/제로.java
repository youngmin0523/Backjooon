import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < K; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	if(tmp == 0) {
        		s.pop();
        	}
        	else {
        		s.push(tmp);
        	}
        }
        int sum = 0;
        while(!s.isEmpty()) {
        	sum += s.pop();
        }
        System.out.println(sum);
    }
}