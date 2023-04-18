import java.util.*;
import java.io.*;
 
public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] basket = new int[N];
        int [] rotationBasket = new int[N];

        for(int i = 0; i < basket.length; i++){
            basket[i] = i+1;
        }

        for(int r = 0; r < M; r++){
            st = new StringTokenizer(br.readLine());
            int i =  Integer.parseInt(st.nextToken())-1;
            int j =  Integer.parseInt(st.nextToken())-1;
            int k =  Integer.parseInt(st.nextToken())-1;

            int i1 = i;

           for(int b = 0; b < j-i+1; b++){
                if(k+b <= j){
                    rotationBasket[b+i] = basket[k+b];
                }else{
                    rotationBasket[b+i] = basket[i1];
                    i1++;
                }
           }
           for(int b = 0; b < N; b++){
               if(rotationBasket[b] != 0){
                   basket[b] = rotationBasket[b];
               }
           }
        }
        br.close();

        for(int i = 0; i < N; i++){
            sb.append(basket[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}    