import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[101][101];
	
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// 스카프 놓아보기
			for(int row = y; row < y+10; row++) {
				for(int col = x; col < x+10; col++) {
					arr[row][col] = 1;
				}
			}
		}
		
		int cnt = 0;
		// 스카프의 둘레 길이 카운트
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				if(arr[i][j] == 1) { // 스카프 천을 찾았다면
					
					// 상
					if(arr[i-1][j] == 0) { // 둘레다!
						cnt++;
					}
					// 하
					if(arr[i+1][j] == 0) { // 둘레다!
						cnt++;
					}
					// 좌
					if(arr[i][j-1] == 0) { // 둘레다!
						cnt++;
					}
					// 우
					if(arr[i][j+1] == 0) { // 둘레다!
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}

}
