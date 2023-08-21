class Solution {
    public long solution(long n) {
        long answer = 0;
        long tmp = 0L;
        boolean tf = false;
        while(true){
            tmp+=1;
            if(tmp*tmp==n){
                tf=true;
                break;
            }
            if(n<tmp) break;
        }
        if(tf){
            answer = (tmp+1)*(tmp+1);
        }
        else answer=-1;
        return answer;
    }
}