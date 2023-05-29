import java.io.*;
import java.util.*;
 
public class Main {
	
	static class Pair implements Comparable<Pair> {
		int index;
		int value;
		
		Pair(int index, int value){
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.value<o.value) {
				return -1;
			}
			else if(this.value>o.value) {
				return 1;
			}
			else {
				if(this.index < o.index) {
					return -1;
				}
				else {
					return 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
        
        List<Pair> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	list.add(new Pair(i, Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
 
        int[] P = new int[1001];
        for(int i = 0; i < N; i++) {
        	P[list.get(i).index] = i;
        }
        
        for(int i = 0; i < N; i++) {
        	System.out.print(P[i] + " ");
        }
	}
}