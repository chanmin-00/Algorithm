import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> tmpArr = new ArrayList<Integer>();
        while(n>0){
            tmpArr.add(n%3);
            n=n/3;
        }

        for(int i=0;i<tmpArr.size();i++){
            int tmpInt = tmpArr.get(tmpArr.size()-i-1);
            for(int j=0;j<i;j++){
                tmpInt*=3;
            }
            answer+= tmpInt;
            
        }
        
        return answer;
    }
}