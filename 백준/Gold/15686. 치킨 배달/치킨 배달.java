import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, cnt, city[][], chicken_road[], min = Integer.MAX_VALUE;
	static boolean isSelected[];
	static List<Place> houses;
	static List<Place> chickens;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N+1][N+1];
		houses = new ArrayList<>();
		chickens = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j] == 1) {
					houses.add(new Place(i, j));
				}
				if(city[i][j] == 2) {
					chickens.add(new Place(i,j));
				}
			}
		}
		isSelected = new boolean[chickens.size()];
		chicken_road = new int[houses.size()];
		comb(0, 0);
		System.out.println(min);
	}
	static void getDistance() {
		int tmp = 0, sum = 0;
		
		for(int j = 0; j < houses.size(); j++) {
			chicken_road[j] = Integer.MAX_VALUE;
		}
		for(int i = 0; i < chickens.size(); i++) {	
			if(isSelected[i]) {
				for(int j = 0; j < houses.size(); j++) {
					tmp = Math.abs(chickens.get(i).r-houses.get(j).r)
							+ Math.abs(chickens.get(i).c-houses.get(j).c);
					if(tmp < chicken_road[j]) {
						chicken_road[j] = tmp;
					}
				}
			}
		}
		for(int i = 0; i < houses.size(); i++) {
			sum += chicken_road[i];
		}
		if(sum < min) {
			min = sum;
		}
	}
	static void comb(int cnt, int start) {
		if(start >= chickens.size()) {
			if(cnt == M) {
				getDistance();
			}
			return;
		}
		
		isSelected[start] = true;
		comb(cnt+1, start+1);
		isSelected[start] = false;
		comb(cnt, start+1);
	}
	static class Place {
		int r, c;

		public Place(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
