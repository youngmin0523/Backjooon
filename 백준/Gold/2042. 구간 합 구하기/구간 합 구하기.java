import java.util.*;
import java.io.*;
 
public class Main {
	
	static int N, M, K, a, b;
	static long arr[], tree[], c;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N+1];
        tree = new long[2*size()];
        
        for(int i = 1; i <= N; i++) {
        	arr[i] = Long.parseLong(br.readLine());
        }
        init(1, N, 1);
        
        for(int i = 0; i < M+K; i++) {
        	st = new StringTokenizer(br.readLine());
        	a = Integer.parseInt(st.nextToken());
        	b = Integer.parseInt(st.nextToken());
        	c = Long.parseLong(st.nextToken());
        	
        	if(a == 1) {
        		long sub = c - arr[b];
        		arr[b] = c;
        		update(1, N, 1, b, sub);
        	}
        	else {
        		sb.append(sum(1, N, 1, b, (int)c)).append('\n');
        	}
        }
        System.out.println(sb.toString());
    }
    static long sum(int start, int end, int index, int b, int c) {
    	if(b > end || c < start) return 0;
    	
    	if(b <= start && c >= end) {
    		return tree[index];
    	}
    	int middle = (start+end)/2;
    	return sum(start, middle, index*2, b, c) + sum(middle+1, end, index*2+1, b, c);
    }
    static void update(int start, int end, int index, int b, long c) {
    	tree[index] += c;
    	if(start == end) return;
    	
    	int middle = (start+end)/2;
    	if(b <= middle) {
    		update(start, middle, index*2, b, c);
    	}
    	else {
    		update(middle+1, end, index*2+1, b, c);
    	}
    }
    static long init(int start, int end, int index) {
    	if(start == end) {
    		return tree[index] = arr[start];
    	}
    	int middle = (start+end)/2;
    	return tree[index] = init(start, middle, index*2) + init(middle+1, end, index*2+1);
    }
    static int size() {
    	int size = 1;
    	while(size < N) {
    		size <<= 1;
    	}
    	return size;
    }
}    