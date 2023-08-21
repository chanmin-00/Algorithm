import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] nstr = String.valueOf(n).split("");
        Integer[] tmp = new Integer[nstr.length];
        String str = "";
        
        for(int i=0;i<tmp.length;i++){
            tmp[i] = Integer.valueOf(nstr[i]);
        }
        
        Arrays.sort(tmp,Collections.reverseOrder());
    
        for(int i=0;i<tmp.length;i++){
            str += tmp[i] + "";
        }
        
        return answer= (long) Long.valueOf(str);
    }
}