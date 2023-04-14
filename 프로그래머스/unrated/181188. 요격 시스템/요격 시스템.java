import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {return o1[1]-o2[1]; });
    
        int cur = targets[0][1]-1;
        answer++;
    
        for(int i = 1; i < targets.length; i++){
            if(cur >= targets[i][0] && cur <= targets[i][1]) continue;
        
            cur = targets[i][1]-1;
            answer++;
        }
        
        return answer;
    }
}