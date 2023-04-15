import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];        
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < N; i++){
            while(!s.isEmpty() && numbers[i] > numbers[s.peek()]){
                answer[s.pop()] = numbers[i];
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            answer[s.pop()] = -1;
        }
        return answer;
    }
}