import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        // int count = 0;
        // HashMap<Integer,Integer> list = new HashMap<>();
        
        for(int i=0;i<number.length-2;i++){
            for(int j=i+1;j<number.length-1;j++){
                for(int k=j+1;k<number.length;k++){
                    if(number[i]+number[j]+number[k]==0)
                        answer++;
                }
            }
        }
        return answer;
    }
}