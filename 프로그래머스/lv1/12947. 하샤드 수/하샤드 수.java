class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int jarisu = 0;
        int xtmp = x;
        
        while(xtmp!=0){
            jarisu += xtmp%10;
            xtmp /= 10;
        }
        if(x%jarisu==0) answer =true;
        else answer = false;
        
        return answer;
    }
}