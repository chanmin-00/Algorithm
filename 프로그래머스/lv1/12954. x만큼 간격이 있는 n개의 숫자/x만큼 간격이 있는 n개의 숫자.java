class Solution {
    public long[] solution(long x, int n) {
        long[] answer = new long[n];
        
        for(int i=0;i<n;i++){
            Integer i2 = i;
            long newi = i2.longValue();
            answer[i] = x + x*newi;
        }
        
        return answer;
    }
}