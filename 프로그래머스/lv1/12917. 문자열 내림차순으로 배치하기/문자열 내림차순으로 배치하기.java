import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] upper = s.replaceAll("[a-z]","").split("");
        String[] notupper = s.replaceAll("[A-Z]","").split("");
        
        Arrays.sort(upper, Collections.reverseOrder());
        Arrays.sort(notupper, Collections.reverseOrder());
        
        for(int i=0;i<notupper.length;i++){
            answer+=notupper[i];
        }
        for(int i=0;i<upper.length;i++){
            answer+=upper[i];
        }
        
        
        return answer;
    }
}