import java.io.*;
import java.util.*;

public class Main {
	static Member[] arr;
	static int id;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new Member[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			arr[i] = new Member(++id, age, name);
		}
		
		Arrays.sort(arr, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				if(o1.age != o2.age) {
					return o1.age - o2.age;
				}
				else {
					return o1.id - o2.id;
				}
			}
		});
		
		for(Member it : arr) {
			System.out.println(it.age + " " + it.name);
		}
		
		
	}
	static class Member {
		int id;
		int age;
		String name;
		
		Member(int id, int age, String name) {
			this.id = id;
			this.age = age;
			this.name = name;
		}
	}
}