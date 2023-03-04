import java.io.*;
import java.util.*;

class Main {
	static int N;
	static List<Integer> list;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
        	list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        int x = list.get(1)-list.get(0);
        for(int i = 1; i < N-1; i++) {
        	x = gcd(x, list.get(i+1)-list.get(i));
        }
        for(int i = 2; i <= x; i++) {
        	if(x % i == 0) {
        		System.out.print(i + " ");
        	}
        }
    }
    static int gcd(int a, int b) {
    	int r;
    	while(b != 0) {
    		r = a % b;
    		a = b;
    		b = r;
    	}
    	return a;
    }
}