import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static StringBuilder sb;
	static String[] str1 = {
			"\"재귀함수가 뭔가요?\"\n",
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"
	};
	static String[] str2 = {
			"\"재귀함수가 뭔가요?\"\n",
			"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n",
			"라고 답변하였지.\n"
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		N = Integer.parseInt(br.readLine());
        
        recursion(0);
        System.out.print(sb.toString());
    }
	static void recursion(int n) {
		if(n == N) {
			for(int i = 0; i < str2.length; i++) {
				for(int j = 0; j < N; j++) {
					sb.append("____");
				}
				sb.append(str2[i]);
			}
			recursion2(N, "라고 답변하였지.\n");
			return;
		}
		for(int i = 0; i < str1.length; i++) {
			for(int j = 0; j < n; j++) {
				sb.append("____");
			}
			sb.append(str1[i]);
		}
		recursion(n+1);
	}
	static void recursion2(int n, String str) {
		for(int i = n-1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				sb.append("____");
			}
			sb.append(str);
		}
	}
}