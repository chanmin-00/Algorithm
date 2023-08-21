import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        ArrayList<Integer> tmpAnswer = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0){
                tmpAnswer.add(arr[i]);
            }
        }
        
        Collections.sort(tmpAnswer);
        
        if(tmpAnswer.size()==0){
            answer = new int[1];
            answer[0]=-1;
        }
        else{
            answer = new int[tmpAnswer.size()];
            for(int i=0;i<tmpAnswer.size();i++){
                answer[i]=tmpAnswer.get(i);
            }
        }
        return answer;
    }
}