import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        ArrayList<Integer> tmpArr = new ArrayList<Integer>();
        
        for(int i=0;i<arr.length;i++){
            if(i==0){
                tmpArr.add(arr[0]);
            }
            if(i>=1){
                if(arr[i]!=arr[i-1])
                tmpArr.add(arr[i]);
            }
                
        }
        answer = new int[tmpArr.size()];
        for(int i=0;i<tmpArr.size();i++){
            answer[i]=tmpArr.get(i);
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}