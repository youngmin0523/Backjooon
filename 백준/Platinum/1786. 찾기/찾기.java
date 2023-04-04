import java.util.*;
import java.io.*;

public class Main {

	static char T[], P[];
	static int tLength, pLength, cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = br.readLine().toCharArray();
		P = br.readLine().toCharArray();
		tLength = T.length;
		pLength = P.length;
		
		int[] pi = new int[pLength];
	    for(int i=1, j=0; i < pLength; i++){
	        while(j > 0 && P[i] != P[j]) j = pi[j-1]; 
	        
	        if(P[i] == P[j]) pi[i] = ++j;
	        else pi[i] = 0;
	    }
		
	    for(int i = 0, j = 0; i < tLength; i++) {
	    	while(j > 0 && T[i] != P[j]) j = pi[j-1];
	    	
	    	if(T[i] == P[j]) {
	    		if(j == P.length-1) {
	    			cnt++;
	    			sb.append(i-j+1).append(' ');
	    			j = pi[j];
	    		}
	    		else {
	    			j++;
	    		}
	    	}
	    }
	    System.out.println(cnt);
	    if(cnt == 0) return;
	    System.out.println(sb.toString());
	}
}
