import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int numer = 1, denom = 1;
		boolean isDown = false;
		
		for(int i = 1; i <= X; i++) {
			if(X == i) break;
			if(numer == 1) {
				if(!isDown) {
					denom++;
					isDown = true;
					continue;
				}
				else {
					numer++;
					denom--;
				}
			}
			else if(denom == 1) {
				if(isDown) {
					numer++;
					isDown = false;
					continue;
				}
				else {
					numer--;
					denom++;
				}
			}
			else {
				if(isDown) {
					numer++;
					denom--;
				}
				else {
					numer--;
					denom++;
				}
			}
		}
		System.out.println(numer + "/" + denom);
	}
}
