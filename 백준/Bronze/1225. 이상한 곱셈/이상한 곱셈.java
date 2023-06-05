import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		
		long ans=0;
		for(int i=0;i<s1.length();i++)
			for(int j=0;j<s2.length();j++)
				ans+=(s1.charAt(i)-'0')*(s2.charAt(j)-'0');
		System.out.println(ans);
	}
}