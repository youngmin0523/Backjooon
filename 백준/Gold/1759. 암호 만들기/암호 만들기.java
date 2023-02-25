import java.io.*;
import java.util.*;

class Main {
	static int L, C;
    static char candidate[], alphabet[];
    static List<Character> resList;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        candidate = new char[L];
        resList = new ArrayList<>();
        alphabet = new char[C];
        
        char input;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input = st.nextToken().charAt(0);
            alphabet[i] = input;
        }
        Arrays.sort(alphabet);
        comb(0, 0);
        
        System.out.println(sb);
    }
    static void comb(int cnt, int start) {
    	if(cnt == L) {
    		int moum = 0, jaum = 0;
    		for(int i = 0; i < cnt; i++) {
    			if(isMoum(candidate[i])) {
    				moum++;
    			}
    			else {
    				jaum++;
    			}
    		}
    		if(moum >= 1 && jaum >= 2) {
    			sb.append(String.valueOf(candidate)).append("\n");
    		}
    		return;
    	}
    	for(int i = start; i < C; i++) {
    		candidate[cnt] = alphabet[i];
    		comb(cnt+1, i+1);
    	}
    }
    static boolean isMoum(char input) {
    	return input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u';
    }
}